package model;

import java.util.ArrayList;
import control.*;

public class StaffDatabase {

	private ArrayList<StaffMember> staff;

	StaffDatabase() {
		staff = new ArrayList<StaffMember>();
	}
	
	/**
	 * Creates a new staff controller based on the privilege level of the logged in user
	 * 
	 * @param ID User ID of the logged in user
	 * @param privilege privilege level of the user
	 * @param courseName course name associated with the user
	 * 
	 * @return a staff controller with the correct permissions and access to methods
	 */
	private StaffController createController(String ID, int privilege, String courseName) {
		switch (privilege) {
			case 0: return new SessionalController(ID);
			
			case 1: return new TimeApproverController(ID);
			
			case 2: return new CourseCoordinatorController(ID, courseName);
			
			case 3: return new TimeAdminController(ID);
		}
		return null;
	}
	
	/**
	 * 
	 * 
	 * @param userID
	 */
	public StaffController logIn(String userID) {
		for (StaffMember s: staff)
			if (s.compareID(userID))
				return createController(s.getID(), s.getPrivilege(), s.getCourseName());
		return null;
	}

	/**
	 * Verifies a users ID and password in the system
	 * 
	 * @param userID userID to compare
	 * @param password password to compare
	 * 
	 * @return true if a match, false otherwise
	 */
	public boolean verifyLogin(String userID, String password) {
		for (StaffMember s: staff)
			if (s.compareID(userID) && s.comparePassword(password))
				return true;

		return false;
	}

	/**
	 * Creates a new staff member
	 * 
	 * @param userID Unique userID associated with a staff member
	 * @param password	Users password
	 * @param qualifications	A list of a staff members course qualifications
	 * @param availabilities	Users availabilities
	 * @param privilege	Users privilege level
	 * @param courseName	Name of a course associated with the user, non-null if user is a course coordinator
	 * 
	 * @return A message containing details of the success or failure of staff creation
	 */
	public String createStaff(String userID, String password, String qualifications, String availabilities, int privilege, String courseName) {
		String failureReason = null;
		
		if (verifyStaff(userID)) {
			failureReason = new String("Staff Member Exists!");
		}
		else if (password.length() < 8) {
			failureReason = new String("Password Insecure!");
		}
		else if (privilege < 0 && privilege > 3) {
			failureReason = new String("Invalid Privilege Level!");
		}
		
		if (failureReason != null)
			return new String("Create Staff failed: " + failureReason);
		
		staff.add(new StaffMember(userID, password, qualifications, availabilities, privilege, courseName));
		
		return new String("Create Staff Successful: " + userID + " " + privilege);
	}

	/**
	 * Verifies that a user exists in the system
	 * 
	 * @param userID userID to compare
	 * 
	 * @return true is user exists, false if not
	 */
	public boolean verifyStaff(String userID) {
		for (StaffMember s: staff)
			if (s.compareID(userID))
				return true;

		return false;
	}

	/**
	 * Finds staff with the correct qualifications for the specified course
	 * 
	 * @param courseName name of the course to check for qualified staff
	 * 
	 * @return a string representation of all the eligible staff
	 */
	public String getEligibleStaff(String courseName) {
		String retStr = new String();
		
		for (StaffMember s: staff)
			if (s.checkQualifications(courseName))
				retStr += s.getID() + "\n";
		
		return retStr;
	}

	/**
	 * Sets a specified users availabilities
	 * 
	 * @param userID ID of the user to set availabilities for
	 * @param availabilities the string representation of the users availabilities
	 */
	public void setAvailabilities(String userID, String availabilities) {
		for (StaffMember s: staff)
			if (s.compareID(userID))
				s.setAvailabilities(availabilities);
	}

	/**
	 * 
	 * 
	 * @param userID
	 */
	public String getStaffMember(String userID) {
		// TODO - implement StaffDatabase.getStaffMember
		throw new UnsupportedOperationException();
	}

	public String export() {
		String retStr = new String();
		
		for (StaffMember s: staff) {
			retStr += s.export() + "\n";
		}
		
		return retStr;
	}
	
}
