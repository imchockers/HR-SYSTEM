package model;

import java.time.*;
import java.util.ArrayList;

public class MasterTimetable {

	/**	List of Disciplines that belong to this Timetable	*/
	private ArrayList<Discipline> disciplines;
	
	/**
	 * Default Constructor
	 */
	MasterTimetable() {
		disciplines = new ArrayList<Discipline>();
	}
	
	/**
	 * Assigned the specified staff member to the specified class
	 * 
	 * @param staffID userID of the staff member to assign
	 * @param classID unique id of the class to assign
	 */
	public boolean assignStaffToClass(String staffID, int classID) {
		ClassInstance c = getClass(classID);
		
		if (c != null)
			return c.assignStaff(staffID);
		return false;
		
	}

	/**
	 * Adds a new class to the specified discipline, creates a new discipline 
	 * if the discipline does not yet exist
	 * 
	 * @param disciplineName name of the discipline to have a class added to
	 * @param courseName name of the course to have a class added to
	 * @param className name of the class to be added
	 * 
	 * @return the ID of the new class
	 */
	public int inputTimetableData(String disciplineName, String courseName, String className) {
		for (Discipline d: disciplines) {
			if (d.getName().compareTo(disciplineName) == 0) {
				return d.inputTimetableData(courseName, className);
			}
		}
		
		Discipline newDiscipline = new Discipline(disciplineName);
		disciplines.add(newDiscipline);
		
		return newDiscipline.inputTimetableData(courseName, className);
	}

	
	/**
	 * Gets string representations of all classes with pending approvals
	 * 
	 * @return string representations of all classes with pending approvals
	 */
	public String getPendingApprovals() {
		String retStr = new String();
		
		for (Discipline d: disciplines)
			retStr += d.getPendingApprovals();
		
		return retStr;
	}

	/**
	 * Approves the current staff assignment to the specified class
	 * 
	 * @param classID unique ID of the class
	 * 
	 * @return true if successful
	 */
	public boolean approveStaffAssignment(int classID) {
		ClassInstance c = getClass(classID);
		
		if (c != null)
			return c.approve();
		return false;
	}
	
	/**
	 * Disapproves the current staff assignment to the specified class
	 * 
	 * @param classID unique ID of the class
	 * 
	 * @return true if successful
	 */
	public boolean disapproveStaffAssignment(int classID) {
		ClassInstance c = getClass(classID);
		
		if (c != null)
			return c.disapprove();
		return false;
	}

	/**
	 * Gets a string representation of all the classes in a specified course
	 * 
	 * @return a string representation of all the classes in a specified course
	 */
	public String getCourseTimetable(String courseName) {
		String retStr = new String();
		
		for (Discipline d: disciplines)
			retStr += d.getCourseTimetable(courseName);
		
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
	 
	public boolean editClass(int classID, String location, String time, String day, int duration) {
		ClassInstance c = getClass(classID);

		if (c != null) {
			c.setLocation(location);
			c.setTime(time);
			c.setDay(day);
			c.setDuration(duration);
			return true;
		}
		return false;
	}*/
	
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
	public boolean editClass(int classID, String location, LocalTime time, DayOfWeek day, Duration duration) {
		ClassDetails c = getClass(classID).getDetails();

		if (c != null) {
			c.setLocation(location);
			c.setTime(time);
			c.setDay(day);
			c.setDuration(duration);
			return true;
		}
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
		ClassInstance c = getClass(classID);

		if (c != null)
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
		
		for (Discipline d: disciplines)
			retStr += d.getSessionalTimetable(userID);
		
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
		
		for (Discipline d: disciplines)
			retStr += d.getOffers(userID);
		
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
		ClassInstance c = getClass(classID);
		
		if (c != null)
			return c.accept(staffID);
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
		ClassInstance c = getClass(classID);
		
		if (c != null)
			return c.reject(staffID);
		return false;
	}

	public String export() {
		String retStr = new String();
		
		for (Discipline d: disciplines) {
			retStr += d.export();
		}
		
		return retStr;
	}
	
	public ClassInstance getClass(int classID) {
		for (Discipline d: disciplines) {
			ClassInstance ci = d.getClass(classID);
			
			if (ci != null)
				return ci;
		}
		
		return null;
	}
}
