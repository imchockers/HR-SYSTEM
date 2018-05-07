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
	public ArrayList<ClassInstance> getPendingApprovals() {
		ArrayList<ClassInstance> list = new ArrayList<ClassInstance>();
		
		for (ClassInstance c: classes) {
			ClassStatus s = c.getStatus();
			if (s.isAssigned() && !s.isApproved())
				list.add(c);
		}
		
		return list;
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
	 * Gets a string representation of the classes that a specific staff member is assigned to
	 * 
	 * @param userID staff members userID
	 * 
	 * @return string representation of the classes that a specific staff member is assigned to
	 */
	public String getSessionalTimetable(String userID) {
		String retStr = new String();
		
		for (ClassInstance c: classes) {
			ClassStatus s = c.getStatus();
			if (s.isAccepted() && s.getStaff().compareTo(userID) == 0)
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
			ClassStatus s = c.getStatus();
			if (!s.isAccepted() && s.isApproved() && s.getStaff().compareTo(userID) == 0)
				retStr += c.toString();
		}
		
		return retStr;
	}

	public String export(String disciplineName) {
		String retStr = new String();
		
		for (ClassInstance c: classes) {
			retStr += disciplineName + "," + name + "," + c.export() + "\n";
		}
		
		return retStr;
	}
	
	
	public ClassInstance getClass(int classID) {
		for (ClassInstance c: classes)
			if (c.getClassID() == classID)
				return c;

		return null;
	}

}
