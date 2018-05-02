package model;

import java.util.ArrayList;

public class Discipline {

	private String name;
	private ArrayList<Course> courses;
	
	Discipline(String name) {
		courses = new ArrayList<Course>();
		this.name = name;
	}
	
	public String getName() { return name; }

	public void addClass(String course, String className, String time, String day, String location, String staffID) {
		for (Course c: courses) {
			if (c.getName().compareTo(course) == 0) {
				c.addClass(className, time, day, location, staffID);
				return;
			}
		}
		
		Course newCourse = new Course(course);
		newCourse.addClass(className, time, day, location, staffID);
		courses.add(newCourse);
		
	}
	
	public String getCourseTimetable(String courseName) {
		String retStr = new String();
		
		for (Course c: courses) {
			if (c.getName().compareTo(courseName) == 0)
				retStr += c.getCourseTimetable();
		}
		
		return retStr;
	}

}
