package model;

import java.io.FileNotFoundException;
import java.time.*;

import Exceptions.InvalidLoginException;
import control.StaffController;

public class Data {

	/**	Master timetable, contains all class data	*/
	private MasterTimetable ttDb;
	/**	Database contains all staff account data	*/
	private StaffDatabase staffDb;
	
	/**
	 * Default constructor
	 */
	public Data() {
		System.out.println("Loading timetable data...");
		try {
			ttDb = DatabaseLoader.loadTimetable();
			System.out.println("Timetable Loaded.");
			System.out.println("Loading staff data...");
			staffDb = DatabaseLoader.loadStaff();
		} catch (FileNotFoundException e) {
			System.out.println("Failed Loading Data: Files Missing");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Staff Loaded.");
	}

	/**
	 * User identification and login
	 * 
	 * @param userID userID to log in as
	 * @param password user password
	 * 
	 * @return controller associated with the user account
	 */
	public StaffController logIn(String userID, String password) throws InvalidLoginException {
		if (staffDb.verifyLogin(userID, password))
			return staffDb.logIn(userID);
		else 
			throw new InvalidLoginException();
	}
	
	/**
	 * Verifies staff and class and then assigns the staff member to the class
	 * 
	 * @param staffID userID of staff member to be assigned
	 * @param classID unique ID of the class to be assigned to
	 * 
	 * @return a message containing information about the class assignment
	 */
	public String assignStaffToClass(String staffID, int classID) {
		if (!staffDb.verifyStaff(staffID))
			return null;
		
		if (!ttDb.verifyClass(classID))
			return null;
		
		if (!ttDb.assignStaffToClass(staffID, classID))
			return null;
		
		return new String("UserID: " + staffID + " Assigned to ClassID: " + classID);
	}

	/**
	 * Adds new data to the timetable
	 *  
	 * @param disciplineName name of the discipline
	 * @param courseName name of the course
	 * @param className name of the class
	 */
	public int inputTimetableData(String disciplineName, String courseName, String className) {
		return ttDb.inputTimetableData(disciplineName, courseName, className);
	}

	public String getPendingApprovals() {
		return ttDb.getPendingApprovals();
	}

	/**
	 * 
	 * @param classID
	 */
	public boolean approveStaffAssignment(int classID) {
		return ttDb.approveStaffAssignment(classID);
	}
	
	public boolean disapproveStaffAssignment(int classID) {
		return ttDb.disapproveStaffAssignment(classID);
	}

	/**
	 * 
	 * @param courseName
	 */
	public String getCourseTimetable(String courseName) {
		return ttDb.getCourseTimetable(courseName);
	}
	
	/**
	 * Edits the details of a specified class
	 * 
	 * @param classID ID of the class to edit
	 * @param location location data to change
	 * @param time time data to change
	 * @param day day data to change
	 * @param duration duration data to change
	 */
	public boolean editClass(int classID, String location, LocalTime time, DayOfWeek day, Duration duration) {
		return ttDb.editClass(classID, location, time, day, duration);
	}

	/**
	 * 
	 * @param userID
	 */
	public String getSessionalTimetable(String userID) {
		return ttDb.getSessionalTimetable(userID);
	}

	/**
	 * 
	 * @param userID
	 */
	public String getOffers(String userID) {
		return ttDb.getOffers(userID);
	}

	/**
	 * 
	 * @param classID
	 * @param staffID
	 */
	public boolean acceptOffer(int classID, String staffID) {
		return ttDb.acceptOffer(classID, staffID);
	}

	/**
	 * 
	 * @param classID
	 * @param staffID
	 */
	public boolean rejectOffer(int classID, String staffID) {
		return ttDb.rejectOffer(classID, staffID);
	}

	/**
	 * Creates a new StaffMember object
	 * 
	  * @param userID Unique userID associated with a staff member
	 * @param password	Users password
	 * @param qualifications	A list of a staff members course qualifications
	 * @param availabilities	Users availabilities
	 * @param privilege	Users privilege level
	 * @param courseName	Name of a course associated with the user, non-null if user is a course coordinator
	 * 
	 * @return a message containing information about the StaffMember created
	 */
	public String createStaff(String userID, String password, String qualifications, String availabilities, int privilege, String courseName) {
		return staffDb.createStaff(userID, password, qualifications, availabilities, privilege, courseName);
	}

	/**
	 * 
	 * @param courseName
	 */
	public String getEligibleStaff(String courseName) {
		return staffDb.getEligibleStaff(courseName);
	}

	/**
	 * 
	 * @param userID
	 * @param availabilities
	 */
	public void setAvailabilities(String userID, String availabilities) {
		staffDb.setAvailabilities(userID, availabilities);
	}

	public String save() {
		return DatabaseLoader.save(ttDb.export(), staffDb.export());
	}
	
}
