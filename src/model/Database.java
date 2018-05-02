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

	// User Identification and Login System
	public StaffController logIn(String userID, String pwd) {
		return staffDb.login(userID, pwd);
	}
	
	// Create and Assign Staff
	public void addStaff(String userID, String pwd, int privilege) {
		staffDb.addStaff(userID, pwd, privilege);
	}
	
	// Input timetabling data
	public void inputTimetableData() {}
	
	// Call reports
	public void callReports() {}
	
	public void approveStaffAssignment() {}
	
	public void viewPendingApprovals() {}
	
	public void viewCourseTimetable() {}
	
	public void viewAvailableStaff() {}
	
	public void assignStaffToClass() {}
	
	public void editClass() {}
	
	public void viewSessionalTimetable() {}
	
	public void submitAvailabilities() {}
	
	public void viewOffers() {}
	
	public void acceptOffer() {}
	
	public void rejectOffer() {}
}
