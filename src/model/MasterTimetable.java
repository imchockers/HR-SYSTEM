package model;

import java.util.ArrayList;

public class MasterTimetable {

	private ArrayList<Discipline> disciplines;
	
	MasterTimetable() {
		disciplines = new ArrayList<Discipline>();
	}
	
	public void addClass(String discipline, String course, String className, String time, String day, String location, String staffID) {
		for (Discipline d: disciplines) {
			if (d.getName().compareTo(discipline) == 0) {
				d.addClass(course, className, time, day, location, staffID);
				return;
			}
		}
		
		Discipline newDiscipline = new Discipline(discipline);
		newDiscipline.addClass(course, className, time, day, location, staffID);
		disciplines.add(newDiscipline);
	}
	
	public String getCourseTimetable(String courseName) {
		String retStr = new String();
		for (Discipline d: disciplines) {
			retStr += d.getCourseTimetable(courseName);
		}
		
		return retStr;
	}
}
