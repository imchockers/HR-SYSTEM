package control;

import Exceptions.InvalidLoginException;
import model.Data;
import view.ConsoleView;

/**
 * Controller used by staff members upon login
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public abstract class StaffController implements Commands {
	
	/**	Database containing all staff and timetable data	*/
	private static Data db = new Data();
	/**	Default input output stream	*/
	private static ConsoleView defaultView = new ConsoleView(System.in, System.out);
	/**	Private input output stream associated with the current logged in user	*/
	private ConsoleView privateView;
	
	/**	ID of the current logged in user	*/
	private String userID;

	/**
	 * Default constructor
	 * 
	 * @param userID ID of the current logged in user
	 */
	StaffController(String userID) {
		privateView = new ConsoleView(System.in, System.out);
		this.userID = userID;
	}
	
	/**
	 * Gets user account details from user and attempts to log in
	 * 
	 * @return Staff Controller associated with the user account logging in
	 * @throws InvalidLoginException 
	 */
	public static StaffController logIn() throws InvalidLoginException {
		String userID = defaultView.getInput("Enter User ID: ");
		String pwd = defaultView.getInput("Enter Password: ");

		return db.logIn(userID, pwd);
	}
	
	/**
	 * Gets and runs commands from user
	 */
	public abstract void getCommands();
	
	/**
	 * 
	 * @return currently logged in user
	 */
	public String getID() { return userID; }
	
	/**
	 * 
	 * @return the current private view associated with the logged in user
	 */
	public ConsoleView getView() { return privateView; }
	
	/**
	 * 
	 * @return the database containing staff and timetable data
	 */
	public Data getDatabase() { return db; }
	
	/**
	 * Prints user commands associated with the current users privilege and default commands
	 * 
	 * @param commands commands associated with the current users privilege
	 */
	public void viewCommands(String commands) {
		privateView.println("Command List:");
		privateView.println(commands);
		privateView.println(VIEW_COMMANDS_DESC + BUFFER + VIEW_COMMANDS + "\n" +
							LOGOUT_DESC + BUFFER + LOGOUT + "\n" +
							EXIT_DESC + BUFFER + EXIT + "\n");
	}

	/**
	 * Gets user input from the current private view
	 * 
	 * @return input string
	 */
	public String getInput() {
		return privateView.getInput("Enter Command: ");
	}
	
	/**
	 * Saves the current database data and exits the program
	 */
	public void exit() {
		privateView.println(db.save());
		System.exit(0);
	}
	
	/**
	 * Prints default welcome information on login
	 */
	public void welcome() {
		privateView.println("Welcome: " + userID + "\n");
	}
	
}