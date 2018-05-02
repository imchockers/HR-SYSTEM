package model;

public class TimetableDatabase implements AccessTimetableDatabase {

	private MasterTimetable tt;

	TimetableDatabase() {
		tt = new MasterTimetable();
	}
	
	public void addClass(String discipline, String course, String classname) {
		tt.addClass(discipline, course, classname);
	}

	public MasterTimetable getData() { return tt; }

	@Override
	public void assignStaffToClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputTimetableData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callReports() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewPendingApprovals() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveStaffAssignment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String viewCourseTimetable(String courseName) {
		return tt.getCourseTimetable(courseName);
	}

	@Override
	public void editClass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewSessionalTimetable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewOffers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptOffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectOffer() {
		// TODO Auto-generated method stub
		
	}
	
}
