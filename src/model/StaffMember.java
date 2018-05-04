package model;

public class StaffMember {

	/**	Unique userID associated with a staff member	*/
	private String userID;
	/**	Users password	*/
	private String password;
	/**	A list of a staff members course qualifications	*/
	private String qualifications;
	/**	Users availabilities	*/
	private String availabilities;
	/**	Users privilege level	*/
	private int privilege;
	/**	Name of a course associated with the user, non-null if user is a course coordinator	*/
	private String courseName;
	
	/**
	 * Default constructor
	 * 
	 * @param userID Unique userID associated with a staff member
	 * @param password	Users password
	 * @param qualifications	A list of a staff members course qualifications
	 * @param availabilities	Users availabilities
	 * @param privilege	Users privilege level
	 * @param courseName	Name of a course associated with the user, non-null if user is a course coordinator
	 */
	public StaffMember(String userID, String password, String qualifications, String availabilities, int privilege, String courseName) {
		this.userID = userID;
		this.password = password;
		this.qualifications = qualifications;
		this.availabilities = availabilities;
		this.privilege = privilege;
		this.courseName = courseName;
	}


	/**
	 * Compares input ID with this users ID
	 * 
	 * @param userID ID to compare with this users ID
	 * @return true if the IDs match
	 */
	public boolean compareID(String userID) {
		if (this.userID.compareTo(userID) == 0)
			return true;
		return false;
	}

	/**
	 * Compares input password with this users password
	 * 
	 * @param password password to compare with this users password
	 * @return true if the passwords match
	 */
	public boolean comparePassword(String password) {
		if (this.password.compareTo(password) == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @return the users userID
	 */
	public String getID() { return userID; }
	
	/**
	 * 
	 * @return course name associated with the user
	 */
	public String getCourseName() { return courseName; }

	/**
	 * Checks to see if the user has a specific course qualification
	 * 
	 * @param courseName name of the course to check within the users qualifications
	 * 
	 */
	public boolean checkQualifications(String courseName) {
		for (String qual: qualifications.split("/"))
			if (qual.compareTo(courseName) == 0)
				return true;
		return false;
	}

	/**
	 * Sets the users availabilities
	 * 
	 * @param availabilities string representing the users available working hours
	 */
	public void setAvailabilities(String availabilities) {
		this.availabilities = availabilities;
	}

	/**
	 * 
	 * @return string representing the users available working hours
	 */
	public String getAvailabilities() {
		return this.availabilities;
	}

	/**
	 * 
	 * @return the users privilege level
	 */
	public int getPrivilege() {
		return this.privilege;
	}
	
	/**
	 * Resets user password with a new password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	public String export() {
		String retStr = new String();
		
		retStr += userID + "," + password + "," + qualifications + "," + availabilities + "," + privilege + "," + courseName;
		
		return retStr;
		
	}
}
