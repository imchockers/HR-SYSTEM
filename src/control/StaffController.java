package control;

import model.AccessStaffDatabase;
import model.AccessTimetableDatabase;
import model.Database;
import view.ConsoleView;

public abstract class StaffController implements AccessTimetableDatabase, AccessStaffDatabase {

	private static Database db = new Database();
	private static ConsoleView defaultView = new ConsoleView(System.in, System.out);
	private ConsoleView privateView;
	
	private String userID;

	StaffController(String userID) {
		privateView = new ConsoleView(System.in, System.out);
		this.userID = userID;
	}
	
	public abstract void getCommands();
	
	public static StaffController logIn() {
		String userID = defaultView.getInput("Enter UserID: ");
		String pwd = defaultView.getInput("Enter Password: ");
		
		return db.logIn(userID, pwd);
	}
	
	public void viewCommands(String commands) {
		privateView.println(commands);
	}
	
	public String getID() { return userID; }

	public String getInput() {
		return privateView.getInput("Enter Command: ");
	}
	
	public void assignStaffToClass() {
		db.assignStaffToClass();
	}
	
	public void inputTimetableData() {
		db.inputTimetableData();
	}
	
	public void callReports() {
		db.callReports();
	}
	
	public void viewPendingApprovals() {
		db.viewPendingApprovals();
	}
	
	public void approveStaffAssignment() {
		db.approveStaffAssignment();
	}
	
	public void viewCourseTimetable() {
		db.viewCourseTimetable();
	}
	
	public void editClass() {
		db.editClass();
	}
	
	public void viewSessionalTimetable() {
		db.viewSessionalTimetable();
	}
	
	public void viewOffers() {
		db.viewOffers();
	}
	
	public void acceptOffer() {
		db.acceptOffer();
	}
	
	public void rejectOffer() {
		db.rejectOffer();
	}
	
	public String createStaff() {
		String userID = defaultView.getInput("Enter new staff UserID: ");
		String pwd = defaultView.getInput("Enter Password (>=8 characters): ");
		int privilege = 0;
		try {
			privilege = Integer.parseInt(defaultView.getInput("Enter Privilege Level (0-3): "));
		} catch (NumberFormatException e) {
			return new String("NumberFormatException: Enter an integer.");
		}
		
		
		return db.createStaff(userID, pwd, privilege);
	}
	
	public void viewEligibleStaff() {
		db.viewEligibleStaff();
	}
	
	public void submitAvailabilities() {
		db.submitAvailabilities();
	}
	
	public void viewStaffMember() {
		db.viewStaffMember();
	}
	
}
