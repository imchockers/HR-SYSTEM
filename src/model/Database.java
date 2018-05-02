package model;

import control.StaffController;

public class Database {

	private TimetableDatabase ttDb;
	private StaffDatabase staffDb;
	
	public Database() {
		System.out.println("Loading timetable data: ");
		ttDb = DatabaseLoader.loadTimetable();
		System.out.println("Loading staff data: ");
		staffDb = DatabaseLoader.loadStaff();
	}

	public StaffController logIn(String userID, String pwd) {
		return staffDb.login(userID, pwd);
	}
	
	public void addStaff(String userID, String pwd, int privilege) {
		staffDb.addStaff(userID, pwd, privilege);
	}
	
}
