package model;

import java.util.ArrayList;

public class Discipline {

	/**	List of courses that belong to this Discipline	*/
	private ArrayList<Course> courses;
	/**	The name of the Discipline	*/
	private String name;
	
	/**
	 * Default constructor
	 * 
	 * @param name The name of the Discipline
	 */
	Discipline(String name) {
		courses = new ArrayList<Course>();
		this.name = name;
	}
	
	/**
	 * Assigned the specified staff member to the specified class
	 * 
	 * @param staffID userID of the staff member to assign
	 * @param classID unique id of the class to assign
	 */
	public boolean assignStaffToClass(String staffID, int classID) {
		for (Course c: courses)
			if (c.assignStaffToClass(staffID, classID))
				return true;
		
		return false;
	}

	/**
	 * Adds a new class to the specified course, creates a new course if the course
	 * does not yet exist
	 * 
	 * @param courseName name of the course to have a class added to
	 * @param className name of the class to be added
	 * 
	 * @return the ID of the new class
	 */
	public int inputTimetableData(String courseName, String className) {
		for (Course c: courses)
			if (c.getName().compareTo(courseName) == 0)
				return c.inputTimetableData(className);
		
		Course newCourse = new Course(courseName);
		courses.add(newCourse);
		
		return newCourse.inputTimetableData(className);
	}

	/**
	 * Gets string representations of all classes with pending approvals
	 * 
	 * @return string representations of all classes with pending approvals
	 */
	public String getPendingApprovals() {
		String retStr = new String();
		
		for (Course c: courses)
			retStr += c.getPendingApprovals();
		
		return retStr;
	}

	/**
	 *
	 * @return the name of this Discipline
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Approves the current staff assignment to the specified class
	 * 
	 * @param classID unique ID of the class
	 * 
	 * @return true if successful
	 */
	public boolean approveStaffAssignment(int classID) {
		for (Course c: courses)
			if (c.approveStaffAssignment(classID))
				return true;
		
		return false;
	}

	/**
	 * Gets a string representation of all the classes in a specified course
	 * 
	 * @return a string representation of all the classes in a specified course
	 */
	public String getCourseTimetable(String courseName) {
		String retStr = new String();
		
		for (Course c: courses)
			if (c.getName().compareTo(courseName) == 0)
				retStr += c.getCourseTimetable();
		
		return retStr;
	}

	/**
	 * Edits the data elements of the class instance
	 * 
	 * @param classID unique ID of the class to be edited
	 * @param location location string of the class
	 * @param time time of the day in 24hr time
	 * @param day day of the week
	 * @param duration duration of the class in minutes
	 * 
	 * @return true if successful
	 */
	public boolean editClass(int classID, String location, String time, String day, int duration) {
		for (Course c: courses)
			if (c.editClass(classID, location, time, day, duration))
				return true;
		
		return false;
	}

	/**
	 * Verifies that a class with the specified ID exists
	 * 
	 * @param classID id of the class to verify'
	 * 
	 * @return true if the class exists false if not
	 */
	public boolean verifyClass(int classID) {
		for (Course c: courses)
			if (c.verifyClass(classID))
				return true;
		
		return false;
	}

	/**
	 * Gets a string representation of the classes that a specific staff member is assigned to
	 * 
	 * @param userID staff members userID
	 * 
	 * @return string representation of the classes that a specific staff member is assigned to
	 */
	public String getSessionalTimetable(String userID) {
		String retStr = new String();
		
		for (Course c: courses)
			retStr += c.getSessionalTimetable(userID);
		
		return retStr;
	}

	/**
	 * Gets a string representation of assignment offers to the specified staff member
	 * 
	 * @param userID ID of the staff member who is being offered a class
	 * 
	 * @return string representation of assignment offers to the specified staff member
	 */
	public String getOffers(String userID) {
		String retStr = new String();
		
		for (Course c: courses)
			retStr += c.getOffers(userID);
		
		return retStr;
	}

	/**
	 * Accepts an offer of the specified class assigned to the specified staff member
	 * 
	 * @param classID unique id of the class that is being accepted
	 * @param staffID userID of the staff member who is accepting the class
	 * 
	 * @return true if successful
	 */
	public boolean acceptOffer(int classID, String staffID) {
		for (Course c: courses)
			if (c.acceptOffer(classID, staffID))
				return true;
		
		return false;
	}

	/**
	 * Rejects an offer of the specified class assigned to the specified staff member
	 * 
	 * @param classID unique id of the class that is being accepted
	 * @param staffID userID of the staff member who is accepting the class
	 * 
	 * @return true if successful
	 */
	public boolean rejectOffer(int classID, String staffID) {
		for (Course c: courses)
			if (c.rejectOffer(classID, staffID))
				return true;
		
		return false;
	}

	public String export() {
		String retStr = new String();
		
		for (Course c: courses) {
			retStr += c.export(name);
		}
		
		return retStr;
	}

}
