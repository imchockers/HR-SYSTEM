package model;

import java.util.ArrayList;

public class Course {

	/**	List of classes that belong to this course	*/
	private ArrayList<ClassInstance> classes;
	/**	The name of the course	*/
	private String name;
	
	/**
	 * Default constructor
	 * 
	 * @param name The name of the course
	 */
	Course(String name) {
		classes = new ArrayList<ClassInstance>();
		this.name = name;
	}

	/**
	 * 
	 * @return the course name
	 */
	public String getName() { return name; }

	/**
	 * Gets a string representation of all the classes in this course
	 * 
	 * @return a string representation of all the classes in this course
	 */
	public String getCourseTimetable() {
		String retStr = new String();
		
		for (ClassInstance c: classes) {
			retStr += c.toString();
		}
		
		return retStr;
	}
	
	/**
	 * Assigned the specified staff member to the specified class
	 * 
	 * @param staffID userID of the staff member to assign
	 * @param classID unique id of the class to assign
	 * 
	 * @return true if successful
	 */
	public boolean assignStaffToClass(String staffID, int classID) {
		for (ClassInstance c: classes)
			if (c.getClassID() == classID) {
				c.assignStaff(staffID);
				return true;
			}
		return false;
	}

	/**
	 * Adds a new classInstance
	 * 
	 * @param className name of the class to add
	 * 
	 * @return the ID of the new class
	 */
	public int inputTimetableData(String className) {
		ClassInstance newClass = new ClassInstance(className);
		classes.add(newClass);
		
		return newClass.getClassID();
	}

	/**
	 * Gets string representations of all classes with pending approvals
	 * 
	 * @return string representations of all classes with pending approvals
	 */
	public String getPendingApprovals() {
		String retStr = new String();
		
		for (ClassInstance c: classes) {
			if (c.isAssigned() && !c.isApproved())
				retStr += c.toString();
		}
		
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
		for (ClassInstance c: classes)
			if (c.getClassID() == classID)
				return c.approve();

		return false;
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
		for (ClassInstance c: classes)
			if (c.getClassID() == classID) {
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
		for (ClassInstance c: classes)
			if (c.getClassID() == classID)
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
		
		for (ClassInstance c: classes) {
			if (c.isAccepted() && c.getStaff().compareTo(userID) == 0)
				retStr += c.toString();
		}
		
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
		
		for (ClassInstance c: classes) {
			if (!c.isAccepted() && c.isApproved() && c.getStaff().compareTo(userID) == 0)
				retStr += c.toString();
		}
		
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
		for (ClassInstance c: classes)
			if (c.getClassID() == classID)
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
		for (ClassInstance c: classes)
			if (c.getClassID() == classID)
				return c.reject(staffID);
		
		return false;
	}

	public String export(String disciplineName) {
		String retStr = new String();
		
		for (ClassInstance c: classes) {
			retStr += disciplineName + "," + name + "," + c.export() + "\n";
		}
		
		return retStr;
	}

}
