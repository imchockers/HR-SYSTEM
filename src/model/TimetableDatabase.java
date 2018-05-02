package model;

public class TimetableDatabase {

	private MasterTimetable tt;

	TimetableDatabase() {
		tt = new MasterTimetable();
	}
	
	public void addClass(String discipline, String course, String classname) {
		tt.addClass(discipline, course, classname);
	}

	public MasterTimetable getData() { return tt; }
	
}
