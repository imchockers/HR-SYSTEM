package control;

public class ApplicationController {

	public static void main(String[] args) {
		while (true) {
		
			StaffController controller = StaffController.logIn();
			
			controller.welcome();
			
			controller.getCommands();
		}
	}

}
