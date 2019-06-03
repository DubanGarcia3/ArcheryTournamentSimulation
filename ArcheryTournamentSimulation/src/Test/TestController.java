package Test;

import controller.Controller;
import persistence.FileManager;

public class TestController {
	
	public static void main(String[] args) {
		Controller c = Controller.getInstance();
		c.manageFile();
		//carga los teams y los player
		c.addTeams();
		c.printTeams();
		
		
		
	}
}
