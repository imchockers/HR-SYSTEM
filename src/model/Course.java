package model;

import java.util.ArrayList;

public class Course {

	private ArrayList<ClassInstance> classes;
	private String name;
	
	
	public Course(String name) {
		classes = new ArrayList<ClassInstance>();
		this.name = name;
	}


	public String getName() { return name; }


	public void addClass(String className, String time, String day, String location, String staffID) {
		classes.add(new ClassInstance(className, time, day, location, staffID));
	}


	public String getCourseTimetable() {
		String retStr = new String();
		
		for (ClassInstance c: classes) {
			retStr += c.toString();
		}
		
		return retStr;
	}
	
	

}
