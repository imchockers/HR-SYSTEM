package model;

import control.StaffController;

public class Database implements AccessTimetableDatabase, AccessStaffDatabase {

	private MasterTimetable ttDb;
	private StaffDatabase staffDb;
	
	public Database() {
		System.out.println("Loading timetable data: ");
		ttDb = DatabaseLoader.loadTimetable();
		System.out.println("Loading staff data: ");
		staffDb = DatabaseLoader.loadStaff();
	}

	// User Identification and Login System
	public StaffController logIn(String userID, String pwd) {
		return staffDb.logIn(userID, pwd);
	}
	
	// Create and Assign Staff
	public void addStaff(String userID, String pwd, int privilege, String courseName) {
		staffDb.addStaff(userID, pwd, privilege, courseName);
	}
	
	public void assignStaffToClass() {}
	
	public void inputTimetableData() {}
	
	public void callReports() {}
	
	public void viewPendingApprovals() {}
	
	public void approveStaffAssignment() {}
	
	public String viewCourseTimetable(String courseName) {
		return ttDb.getCourseTimetable(courseName);
	}
	
	public void editClass() {}
	
	public void viewSessionalTimetable() {}
	
	public void viewOffers() {}
	
	public void acceptOffer() {}
	
	public void rejectOffer() {}
	
	public String createStaff(String userID, String pwd, int privilege, String courseName) {
		staffDb.addStaff(userID, pwd, privilege, courseName);
		
		return null;
	}
	
	public void viewEligibleStaff() {}
	
	public void submitAvailabilities() {}
	
	public void viewStaffMember() {}

	@Override
	public String createStaff() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
