package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.entities.Gender;
import model.entities.Player;
import persistence.FileManager;

public class Controller {
	
	public static Controller controller;
	private List<Player> listData;
	private FileManager fileManager;
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private Controller() {
		listData = new ArrayList<Player>();
		
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
