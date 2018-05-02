package model;

public class StaffMember {

	private String userID;
	private String pwd;
	private int privilege;
	private String courseName;
	
	
	public StaffMember(String userID, String pwd, int privilege, String courseName) {
		this.userID = userID;
		this.pwd = pwd;
		this.privilege = privilege;
		this.courseName = courseName;
	}


	public boolean compareID(String userID) {
		if (this.userID.compareTo(userID) == 0)
			return true;
		return false;
	}


	public boolean comparePwd(String pwd) {
		if (this.pwd.compareTo(pwd) == 0)
			return true;
		return false;
	}


	public String getID() { return userID; }


	public Object getPwd() { return pwd; }


	public int getPrivilege() { return privilege; }
	
	public String getCourseName() { return courseName; }
	
}
