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

	public void addClass(String course, String className) {
		for (Course c: courses) {
			if (c.getName().compareTo(course) == 0) {
				c.addClass(className);
				return;
			}
		}
		
		Course newCourse = new Course(course);
		newCourse.addClass(className);
		courses.add(newCourse);
		
	}

}
