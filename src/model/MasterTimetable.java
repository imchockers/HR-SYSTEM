package model;

import java.util.ArrayList;

public class MasterTimetable {

	private ArrayList<Discipline> disciplines;
	
	MasterTimetable() {
		disciplines = new ArrayList<Discipline>();
	}
	
	public void addClass(String discipline, String course, String className) {
		for (Discipline d: disciplines) {
			if (d.getName().compareTo(discipline) == 0) {
				d.addClass(course, className);
				return;
			}
		}
		
		Discipline newDiscipline = new Discipline(discipline);
		newDiscipline.addClass(course, className);
		disciplines.add(newDiscipline);
	}
}
