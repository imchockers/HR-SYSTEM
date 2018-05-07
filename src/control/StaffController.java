package control;

import model.Database;
import view.ConsoleView;

public abstract class StaffController implements Commands {
	
	private static Database db = new Database();
	private static ConsoleView defaultView = new ConsoleView(System.in, System.out);
	private ConsoleView privateView;
	
	private String userID;

	StaffController(String userID) {
		privateView = new ConsoleView(System.in, System.out);
		this.userID = userID;
	}
	
	public static StaffController logIn() {
		String userID = defaultView.getInput("Enter User ID: ");
		String pwd = defaultView.getInput("Enter Password: ");
		
		return db.logIn(userID, pwd);
	}
	
	public abstract void getCommands();
	
	public String getID() { return userID; }
	
	public ConsoleView getView() { return privateView; }
	
	public Database getDatabase() { return db; }
	
	public void viewCommands(String commands) {
		privateView.println("Command List:");
		privateView.println(commands);
		privateView.println(VIEW_COMMANDS_DESC + BUFFER + VIEW_COMMANDS + "\n" +
							LOGOUT_DESC + BUFFER + LOGOUT + "\n" +
							EXIT_DESC + BUFFER + EXIT + "\n");
	}

	public String getInput() {
		return privateView.getInput("Enter Command: ");
	}
	
	public void exit() {
		privateView.println(db.save());
		System.exit(0);
	}
	
	public void welcome() {
		privateView.println("Welcome: " + userID + "\n");
	}
	
}