package control;

/**
 * Main Application controller
 * 
 * Run from this class
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public class ApplicationController {

	public static void main(String[] args) {
		while (true) {
		
			StaffController controller = StaffController.logIn();
			
			controller.welcome();
			
			controller.getCommands();
		}
	}

}
