package control;

import model.Database;
import view.ConsoleView;

public interface Coordination {
	
	public default void assignStaffToClass(ConsoleView privateView, Database db) {
		String staffID = privateView.getInput("Enter user ID: ");
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		
		privateView.println(db.assignStaffToClass(staffID, classID) + "\n");
	}

	public default void viewCourseTimetable(ConsoleView privateView, Database db, String courseName) {
		privateView.println("Current Course Timetable:");
		privateView.println(db.getCourseTimetable(courseName) + "\n");
	}
	
	public default void viewEligibleStaff(ConsoleView privateView, Database db, String courseName) {
		privateView.println("Staff Eligible to be Assigned to " + courseName + ":");
		privateView.println(db.getEligibleStaff(courseName) + "\n");
	}
	
	public default void editClass(ConsoleView privateView, Database db) {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		editClass(privateView, db, classID);
	}
	
	public default void editClass(ConsoleView privateView, Database db, int classID) {
		String location = privateView.getInput("Enter Location (xx.xx.xx): ");
		String time = privateView.getInput("Enter Time 24hr time XXXX: ");
		String day = privateView.getInput("Enter day of the week (mon,tue,wed,thu,fri): ");
		int duration = Integer.parseInt(privateView.getInput("Enter Class Duration in minutes: "));
		
		if(db.editClass(classID, location, time, day, duration))
			privateView.println("Class Details added Successfully!" + "\n");
		else
			privateView.println("Class Details adding Failed!" + "\n");
	}
	
}