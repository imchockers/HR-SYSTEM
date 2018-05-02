package model;

public class ClassInstance {

	private String name;
	private String time;
	private String day;
	private String location;
	private String staffID;
	
	ClassInstance(String name, String time, String day, String location, String staffID) {
		this.name = name;
		this.time = time;
		this.day = day;
		this.location = location;
		this.staffID = staffID;
	}
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getTime() { return time; }

	public void setTime(String time) { this.time = time; }

	public String getDay() { return day; }

	public void setDay(String day) { this.day = day; }

	public String getLocation() { return location; }

	public void setLocation(String location) { this.location = location; }

	public String getStaffID() { return staffID; }

	public void setStaffID(String staffID) { this.staffID = staffID; }
	
	@Override
	public String toString() {
		
		return new String(	name + ", " +
							day + ", " + 
							time + ", " + 
							location + ", " + 
							staffID + "\n"	);
	}
}
