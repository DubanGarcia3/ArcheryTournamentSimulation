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
		count = 0;
	}

	/**
	 * Metodo crear 1 partida en construccion! 
	 */
	public void createMatch() {
//		match = new Match(daoTeams.get(0), daoTeams.get(1));
		
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
			System.out.println(count);
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
			for (int i = 0; i < fileManager.readFile().size(); i++) {
				listData.add(this.createPlayer(FileManager.splitLine(fileManager.readFile().get(i), ",")));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public Player createPlayer(String []in) {
		return new Player(in[0],Gender.valueOf(in[1].toString()), Integer.parseInt(in[2]), Integer.parseInt(in[3]),
				Integer.parseInt(in[4]), Integer.parseInt(in[5]), Double.parseDouble(in[6]));
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}
}
