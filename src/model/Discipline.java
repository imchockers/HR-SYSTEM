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
	 * Gets all classes with pending approvals
	 * 
	 * @return an array all classes with pending approvals
	 */
	public ArrayList<ClassInstance> getPendingApprovals() {
		ArrayList<ClassInstance> list = new ArrayList<ClassInstance>();
		
		for (Course c: courses)
			list.addAll(c.getPendingApprovals());
		
		return list;
	}

	/**
	 *
	 * @return the name of this Discipline
	 */
	public String getName() {
		return this.name;
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

	public String export() {
		String retStr = new String();
		
		for (Course c: courses) {
			retStr += c.export(name);
		}
		
		return retStr;
	}

	public ClassInstance getClass(int classID) {
		for (Course c: courses) {
			ClassInstance ci = c.getClass(classID);
			
			if (ci != null)
				return ci;
		}
		return null;
	}

}
