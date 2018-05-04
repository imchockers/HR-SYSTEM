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
	
	public abstract void getCommands();
	
	public void viewCommands(String commands) {
		privateView.println(commands);
	}
	
	public String getID() { return userID; }

	public String getInput() {
		return privateView.getInput("Enter Command: ");
	}
	
	public void assignStaffToClass() {
		String staffID = privateView.getInput("Enter user ID: ");
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		
		privateView.println(db.assignStaffToClass(staffID, classID));
	}
	
	public void inputTimetableData() {
		String discipline = privateView.getInput("Enter Discipline Name: ");
		String course = privateView.getInput("Enter Course Name: ");
		String className = privateView.getInput("Enter Class Name: ");
		
		int classID = db.inputTimetableData(discipline, course, className);
		
		editClass();
		
		privateView.println("New Class Added! ID: " + classID);
	}
	
	public void viewPendingApprovals() {
		privateView.println(db.getPendingApprovals());
	}
	
	public void approveStaffAssignment() {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));

		if(db.approveStaffAssignment(classID))
			privateView.println("Approval Successful!");
		else
			privateView.println("Approval Failed!");
	}
	
	public void viewCourseTimetable(String courseName) {
		privateView.println(db.getCourseTimetable(courseName));
	}
	
	public void editClass() {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		editClass(classID);
	}
	
	private void editClass(int classID) {
		String location = privateView.getInput("Enter Location (xx.xx.xx): ");
		String time = privateView.getInput("Enter Time 24hr time XXXX: ");
		String day = privateView.getInput("Enter day of the week (mon,tue,wed,thu,fri): ");
		int duration = Integer.parseInt(privateView.getInput("Enter Class Duration in minutes: "));
		
		if(db.editClass(classID, location, time, day, duration))
			privateView.println("Class Details added Successfully!");
		else
			privateView.println("Class Details adding Failed!");
	}
	
	public void viewSessionalTimetable() {
		privateView.println(db.getSessionalTimetable(userID));
	}
	
	public void viewOffers() {
		privateView.println(db.getOffers(userID));
	}
	
	public void acceptOffer() {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		
		if(db.acceptOffer(classID, userID))
			privateView.println("Offer Accepted Successfully!");
		else
			privateView.println("Offer Accept Failed!");
	}
	
	public void rejectOffer() {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		
		if(db.rejectOffer(classID, userID))
			privateView.println("Offer Rejected Successfully!");
		else
			privateView.println("Offer Reject Failed!");
		
	}
	
	public void createStaff() {
		String userID = privateView.getInput("Enter new staff UserID: ");
		String pwd = privateView.getInput("Enter Password (>=8 characters): ");
		int privilege = 0;
		String courseName = "";
		
		try {
			privilege = Integer.parseInt(privateView.getInput("Enter Privilege Level (0-3): "));
		} catch (NumberFormatException e) {
			privateView.println("NumberFormatException: Enter an integer.");
		}
		
		if (privilege == 2)
			courseName = privateView.getInput("Enter Course Name: ");
		
		privateView.println(db.createStaff(userID, pwd, null, null, privilege, courseName));
	}
	
	public void viewEligibleStaff() {
		String courseName = privateView.getInput("Enter Course Name: ");

		viewEligibleStaff(courseName);
	}
	
	public void viewEligibleStaff(String courseName) {
		privateView.println(db.getEligibleStaff(courseName));
	}
	
	public void submitAvailabilities() {
		String availabilities = privateView.getInput("Enter Availabilities Name (<day>/<start-time 24hrs XXXX>-<end-time 24hrs XXXX>~<day>/<start-time 24hrs XXXX>-<end-time 24hrs XXXX>...): ");
		
		db.setAvailabilities(userID, availabilities);
	}
	
	public void viewStaffMember() {
		// TODO - implement StaffController.viewStaffMember
		throw new UnsupportedOperationException();
	}
	
	public void exit() {
		privateView.println(db.save());
		System.exit(0);
	}
	
}