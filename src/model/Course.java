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


	public void addClass(String className) {
		classes.add(new ClassInstance(className));
	}

}
