package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.Manager.DaoMatches;
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

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	private Controller() {
		listData = new ArrayList<Player>();
		daoMatches = new DaoMatches();
	}

	public Team createTeam(){
		Team team = new Team();
		for (int i = 0; i < 20; i++) {
			team.addPlayerToTeam(listData.get(i));
		}
		return team;
	}
	
	public void delete() {
		ArrayList<Player> aux = new ArrayList<Player>();
 		for (int i = 0; i < 20; i++) {
			listData.remove(listData.get(i-1));
 		}
	}
	
	public void printTeams(Team team) {
		for (int i = 0; i < 20; i++) {
			System.out.println(team.getPlayerList().get(i));
		}
	}


	//	public void printMatch() {
	//		System.out.println("TEAM A                                                                                                    	  TEAM B");
	//		for (int i = 0; i < 20; i++) {
	//			System.out.println(match.getTeam1().getPlayerList().get(i)+"						"+match.getTeam2().getPlayerList().get(i));
	//		}
	//	}

	public void manageFile() {
		try {
			for (int i = 0; i < fileManager.readFile().size(); i++) {
				listData.add(this.createPlayer(FileManager.splitLine(fileManager.readFile().get(i), ",")));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void printData() {
		for (int i = 0; i < 100; i++) {
			System.out.println(listData.get(i));
		}
	}

//	public void printData() {
//		System.out.println("TEAM A                                                                                                    	  TEAM B");
//		for (int i = 0; i < 20; i++) {
//			System.out.println(match.getTeam1().getPlayerList().get(i)+"						"+match.getTeam2().getPlayerList().get(i));
//		}
//	}

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
