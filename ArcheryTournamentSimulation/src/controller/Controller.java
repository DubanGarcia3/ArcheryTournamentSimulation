package controller;

public class Controller {
	
	public static Controller controller;
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	private Controller() {
	}

}
