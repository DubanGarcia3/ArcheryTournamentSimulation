package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Gender;
import model.entities.Match;
import model.entities.Player;
import model.entities.Team;
import persistence.FileManager;

public class Controller {
	
	public static Controller controller;
	private List<Player> listData;
	private FileManager fileManager;
	private Team teamA;
	private Team teamB;
	private Match match;
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private Controller() {
		listData = new ArrayList<Player>();
		match = new Match();
		teamA = new Team();
		teamB = new Team();
	}
	
	public void createMatch(){
		match.createMatch(teamA, teamB);
	}
	
	public void printMatch() {
		System.out.println("TEAM A                                                                                                    	  TEAM B");
		for (int i = 0; i < 20; i++) {
			System.out.println(match.getTeam1().getPlayerList().get(i)+"						"+match.getTeam2().getPlayerList().get(i));
		}
	}
	
	public void createTeam(){
		for (int i = 0; i < 20; i++) {
			teamA.addPlayerToTeam(listData.get(i));
		}
		for (int i = 20; i < 40; i++) {
			teamB.addPlayerToTeam(listData.get(i));
		}
	}
	
	public void manageFile() {
		try {
			for (int i = 0; i < fileManager.readFile().size(); i++) {
				listData.add(this.createPlayer(FileManager.splitLine(fileManager.readFile().get(i), ",")));
			}
			for (int i = 0; i < listData.size(); i++) {
				System.out.println(listData.get(i).toString());
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
