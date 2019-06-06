package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.Manager.DaoMatches;
import dao.Manager.ManagerShot;
import model.entities.Gender;
import model.entities.Match;
import model.entities.Player;
import model.entities.Team;
import model.entities.Weather;
import persistence.FileManager;

public class Controller {

	public static Controller controller;
	private List<Player> listData;
	private FileManager fileManager;
	private DaoMatches daoMatches;
	private Match match;
	private ArrayList<Team> daoTeams;
	private int count;
	private ManagerShot managerShot;
	private Weather weather;

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	private Controller() {
		listData = new ArrayList<Player>();
		daoMatches = new DaoMatches();
		daoTeams = new ArrayList<Team>();
		managerShot = new ManagerShot();
		fileManager = new FileManager();
		weather = new Weather();
		count = 0;
	}

	/**
	 * Metodo crear 1 partida en construccion! VERSION 2.0
	 */
	public void createMatch() {
		for (int j = 0; j < 5; j = j+2) {
			
		match = new Match(daoTeams.get(j), daoTeams.get(j+1), managerShot, weather.getListWeather().get((int) (Math.random() * 500) + 0));
		System.out.println("Escenario de juego: "+match.getWeather().getName());
		while (match.getCountTeamA() < 10  &&  match.getCountTeamB() < 10) {
			match.clearList();
			match.generateRound();
			manageRaffleShot();
			double valueA = daoTeams.get(j).calculateTotalDistance();
			double valueB = daoTeams.get(j+1).calculateTotalDistance();
//			incrementa la distancia en diparo para el que tenga exp =18
			daoTeams.get(j).incrementDistance();
			daoTeams.get(j+1).incrementDistance();
			if ( valueA > valueB ) {
				match.addRound(daoTeams.get(j).calculateTotalDistance() , daoTeams.get(j).getId());
				manageIndividualWinner();
			}else {
				match.addRound(daoTeams.get(j+1).calculateTotalDistance() , daoTeams.get(j+1).getId());
				manageIndividualWinner();
			}
		}
		daoMatches.addMatch(match);
//		System.out.println("team1 "+ daoTeams.get(0).calculateTotalDistance());
		//		System.out.println("team2 "+ daoTeams.get(1).calculateTotalDistance());
		//		for (int i = 0; i < daoTeams.get(0).getPlayerList().size(); i++) {
		//			System.out.println("Disparo jugador " + i +"--->\t"+ daoTeams.get(0).getPlayerList().get(i).getListShots().toString());
		//		}
		System.out.println("Cantidad de rondas ganadas por grupo: "+"TEAM A "+match.getCountTeamA()+"    "+"TEAM B "+match.getCountTeamB());
		for (int i = 0; i < match.getListRound().size(); i++) {
			System.out.println(match.getListRound().get(i));
		}
//		manageIndividualWinner();
		manageWeatherOnShot();
		}
		
//		for (int i = 0; i < daoMatches.getListMatches().size(); i++) {
//			System.out.println(daoMatches.getListMatches().get(i));
//		}
//		System.out.println(daoMatches.getListMatches().size());
	}
	
	public void manageRaffleShot() {
		match.getPlayerLuckier();
	}
	
	/**
	 * metodo que maneja las variables exogenas (clima )
	 */
	public void manageWeatherOnShot() {
//		for (int i = 0; i < match.getTeam1().getPlayerList().size(); i++) {
//			System.out.println(match.getTeam1().getPlayerList().get(i).getListShots());
//		}
//		match.calculateShootOnWeather();
//		System.out.println(match.getWeather().getName());
//		System.out.println("Disparos alterados por anomalia en el clima");
//		for (int i = 0; i < match.getTeam1().getPlayerList().size(); i++) {
//			System.out.println(match.getTeam1().getPlayerList().get(i).getListShots());
//		}
	}
	
	
	/**
	 * metodo que saca el ganador por ronda individual
	 */
	public void manageIndividualWinner() {
		match.calculateindividualWinner().incrementEXP();
		System.out.println(match.calculateindividualWinner() + " distancia: "+
				match.calculateindividualWinner().getTotalDistance()+" mts");
	}

	/**
	 * Este metodo crea los teams, cargando los jugadores para cada uno, con un tamaño de 20 exactos
	 * 
	 * @param init Este parametro ingresa al metodo, para que no cree los TEAMS con los mismos jugadores.
	 * @return Regresa un Team
	 */	
	public Team createTeam(int init){
		Team team = new Team();
		for (int i = init; i < (init+20); i++) {
			team.addPlayerToTeam(listData.get(i));
		}
		return team;
	}
	/** 
	 *Este metodo agrega a una lista de TEAMS, cada team que es creado en el anterior metodo
	 *Se crean 1000 teams, alrededor de 20 mil jugadores, para un total de 500 partidas. 
	 */
	public void addTeams() {
		for (int i = 0; i < 1000; i++) {
			daoTeams.add(createTeam(count));
			count = count + 20;
		}
	}
	/**
	 * Imprime los jugadores de cada equipo que este en la lista de equipos.
	 */
	public void printTeams() {
		for (int i = 0; i < daoTeams.size(); i++) {
			for (int j = 0; j < 20; j++) {
				System.out.println(daoTeams.get(i).getPlayerList().get(j));
			}
		}
	}

	public void manageFile() {
		try {
			List<String> file = FileManager.readFile();
			for (int i = 0; i < file.size(); i++) {
				listData.add(this.createPlayer(FileManager.splitLine(file.get(i), ",")));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public Player createPlayer(String []in) {
		return new Player(in[0],Gender.valueOf(in[1].toString()), Integer.parseInt(in[2]), Integer.parseInt(in[3]),
				Integer.parseInt(in[4]), Integer.parseInt(in[5]), Double.parseDouble(in[6]));
	}

	public void loadData() {
		this.manageFile();
		this.addTeams();
		managerShot.addFromPersistence();
		try {
			FileManager.readFileLanzamientos();
			FileManager.readFileWeather();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * el metodo donde se llama a todos los reportes
	 * @return
	 */
	public void managerReports(){
		this.averageExp();
		this.averageLuckyEarned();
		this.showLuckiestplayer();
	}
	
	//no se si está bien *2
	public void averageLuckyEarned() {
		double average = 0;
		for (int i = 0; i < daoMatches.getListMatches().size(); i++) {
			if (daoMatches.getListMatches().get(i) == null) {
				average = daoMatches.getListMatches().get(i).getLuckyEarned(daoMatches.getListMatches().get(i).getTeam1()) + 
						daoMatches.getListMatches().get(i).getLuckyEarned(daoMatches.getListMatches().get(i).getTeam2());
				System.out.println("La partida " + (i+1) + "obtuvo en promedio " + (average/40) + " puntos de suerte ganados.");
			}
		}
	}
	
	
	//no se ha probado 
	public void  averageExp() {
		double average1 = 0;
		for (int i = 0; i < daoMatches.getListMatches().size(); i++) {
			if (daoMatches.getListMatches().get(i) != null) {
				//el += va?
				average1 = daoMatches.getListMatches().get(i).getExpEarned(daoMatches.getListMatches().get(i).getTeam1()) + 
						daoMatches.getListMatches().get(i).getExpEarned(daoMatches.getListMatches().get(i).getTeam2());
				System.out.println("La partida " + (i+1) + " obtuvo en promedio " + 
						(average1/(daoMatches.getListMatches().get(i).getTeam1().getOnlyExp() +
								daoMatches.getListMatches().get(i).getTeam2().getOnlyExp())
						) + " experiencia ganada.");
			}
		}
	}
	
	//Jugador con más suerte en cada uno de los escenarios de juego
	public void showLuckiestplayer() {
		Player playerAux = null;
		for (int i = 0; i < daoMatches.getListMatches().size(); i++) {
			if (daoMatches.getListMatches().get(i).getWeather().getName() == "Lluvioso") {
				if (daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getLucky() >=
						daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getLucky()) {
					System.out.println("Jugador con mas suerte en escenario Lluvioso " + 
							daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getName());
				}else {
					System.out.println("Jugador con mas suerte en escenario Lluvioso " + 
							daoMatches.getListMatches().get(i).getTeam2().getPleyerLuckier(managerShot).getName());
				}
				playerAux = daoMatches.getListMatches().get(i).getTeam2().getPleyerLuckier(managerShot);

			}else if (daoMatches.getListMatches().get(i).getWeather().getName() == "Soleado") {
				if (daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getLucky() >=
						daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getLucky()) {
					System.out.println("Jugador con mas suerte en escenario Soleado " + 
							daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getName());
				}else {
					System.out.println("Jugador con mas suerte en escenario Soleado " + 
							daoMatches.getListMatches().get(i).getTeam2().getPleyerLuckier(managerShot).getName());
				}
			}else if (daoMatches.getListMatches().get(i).getWeather().getName() == "Viento") {
				if (daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getLucky() >=
						daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getLucky()) {
					System.out.println("Jugador con mas suerte en escenario viento " + 
							daoMatches.getListMatches().get(i).getTeam1().getPleyerLuckier(managerShot).getName());
				}else {
					System.out.println("Jugador con mas suerte en escenario Soleado " + 
							daoMatches.getListMatches().get(i).getTeam2().getPleyerLuckier(managerShot).getName());
				}
			}
		}
	}
	
	

	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}
}
