package control;

public class ApplicationController {

	public static void main(String[] args) {
		while (true) {
		
			StaffController controller = StaffController.logIn();
			System.out.println("Logged In as: " + controller.getID() + ", " + controller.getClass());
			
			controller.getCommands();
		}
	}

}
