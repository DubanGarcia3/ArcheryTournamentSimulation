package run;

import controller.Controller;

public class Runner {
	
	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		controller.loadData();
		controller.createMatch();
//		controller.manageRaffleShot();
//		controller.manageIndividualWinner();
//		System.out.println("------------------------------------");
//		controller.manageWeatherOnShot();
	}
}
