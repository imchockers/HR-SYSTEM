package control;

import model.Database;
import view.ConsoleView;

public abstract class StaffController {

	private static Database db = new Database();
	private static ConsoleView defaultView = new ConsoleView(System.in, System.out);
	private ConsoleView privateView;
	
	private String userID;
	
	StaffController(String userID) {
		privateView = new ConsoleView(System.in, System.out);
		this.userID = userID;
	}
	
	public static StaffController logIn() {
		String userID = defaultView.getInput("Enter UserID: ");
		String pwd = defaultView.getInput("Enter Password: ");
		
		return db.logIn(userID, pwd);
	}
	
	public String getID() { return userID; }

	public String getInput() {
		return privateView.getInput("Enter Command: ");
	}
	
	public void assignClass() {
		
	}
	
	public void getEligibleStaff() {
		
	}

	public void getUnassignedClasses() {
		
	}
	
	public abstract void getCommands();
	
	
}
