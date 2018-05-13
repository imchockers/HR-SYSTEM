package control;

import java.time.*;

import model.Database;
import view.ConsoleView;

/**
 * Coordination interface, contains default coordination methods
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public interface Coordination {
	
	/**
	 * Gets user input and assigns specified staff member to specified class
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 */
	public default void assignStaffToClass(ConsoleView privateView, Database db) {
		String staffID = privateView.getInput("Enter user ID: ");
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		
		privateView.println(db.assignStaffToClass(staffID, classID) + "\n");
	}

	/**
	 * Views a course timetable
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 * @param courseName name of the course timetable to view
	 */
	public default void viewCourseTimetable(ConsoleView privateView, Database db, String courseName) {
		privateView.println("Current Course Timetable:");
		privateView.println(db.getCourseTimetable(courseName) + "\n");
	}
	
	/**
	 * Views staff eligible for a course
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 * @param courseName name of the course staff should be eligible for
	 */
	public default void viewEligibleStaff(ConsoleView privateView, Database db, String courseName) {
		privateView.println("Staff Eligible to be Assigned to " + courseName + ":");
		privateView.println(db.getEligibleStaff(courseName) + "\n");
	}
	
	/**
	 * Gets user input and edits specified class details
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 */
	public default void editClass(ConsoleView privateView, Database db) {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));
		editClass(privateView, db, classID);
	}
	
	/**
	 * Gets user input and edits details of a specified class
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 * @param classID ID of class to edit
	 */
	public default void editClass(ConsoleView privateView, Database db, int classID) {
		String location = privateView.getInput("Enter Location (xx.xx.xx): ");
		LocalTime time = LocalTime.parse(privateView.getInput("Enter Time 24hr time HH:MM: "));
		DayOfWeek day = DayOfWeek.valueOf(privateView.getInput("Enter day of the week (MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY): ").toUpperCase());
		int duration = Integer.parseInt(privateView.getInput("Enter Class Duration in minutes: "));
		
		if(db.editClass(classID, location, time, day, Duration.parse("PT" + duration + "M")))
			privateView.println("Class Details added Successfully!" + "\n");
		else
			privateView.println("Class Details adding Failed!" + "\n");
	}
	
}