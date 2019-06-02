package Test;

import controller.Controller;
import persistence.FileManager;

public class TestController {
	
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		Controller c = Controller.getInstance();
		c.setFileManager(fileManager);
		c.manageFile();
		
		c.printTeams(c.createTeam());
		c.printData();
		System.out.println("Borra");
		c.delete();
		System.out.println("Ya borro");
		c.printData();
	}
}
