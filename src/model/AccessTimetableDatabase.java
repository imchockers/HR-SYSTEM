package model;

public interface AccessTimetableDatabase {
	
	public abstract void assignStaffToClass();
	
	public abstract void inputTimetableData();
	
	public abstract void callReports();
	
	public abstract void viewPendingApprovals();
	
	public abstract void approveStaffAssignment();
	
	public abstract String viewCourseTimetable(String courseName);
	
	public abstract void editClass();
	
	public abstract void viewSessionalTimetable();
	
	public abstract void viewOffers();
	
	public abstract void acceptOffer();
	
	public abstract void rejectOffer();
	

}
