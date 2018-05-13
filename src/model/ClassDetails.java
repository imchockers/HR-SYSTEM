package model;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Details regarding the running of a ClassInstance
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public class ClassDetails {

	/**	ClassInstance name	*/
	private String name;
	/**	Day of the week the class occurs	*/
	private DayOfWeek day;
	/**	Time of day the class occurs 24hr time	*/
	private LocalTime time;
	/**	Classroom Location	*/
	private String location;
	/**	duration of the class in minutes	*/
	private Duration duration;
	
	/**
	 * Default constructor
	 * 
	 * @param name
	 */
	public ClassDetails(String name) {
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() { return name; }

	/**
	 * @param name the name to set
	 */
	public void setName(String name) { this.name = name; }

	/**
	 * @return the day of the week
	 */
	public DayOfWeek getDay() { return day; }

	/**
	 * @param day the day of the week to set
	 */
	public void setDay(DayOfWeek day) { this.day = day; }

	/**
	 * @return the time of the class
	 */
	public LocalTime getTime() { return time; }

	/**
	 * @param time the time of the class to set
	 */
	public void setTime(LocalTime time) { this.time = time; }

	public LocalTime getEndTime() { return this.time.plus(duration); }
	
	/**
	 * @return the location of the class
	 */
	public String getLocation() { return location; }

	/**
	 * @param location the location of the class to set
	 */
	public void setLocation(String location) { this.location = location; }

	/**
	 * @return the duration of the class
	 */
	public Duration getDuration() { return duration; }

	/**
	 * @param duration the duration of the class to set
	 */
	public void setDuration(Duration duration) { this.duration = duration; }

	/**
	 * Checks if two class times will clash
	 * 
	 * @param cd Class details to compare against
	 * @return true if the classes clash, false if not
	 */
	public boolean checkClash(ClassDetails cd) {
		// Check if the day clashes
		if (cd.getDay().equals(day))
			return true;
		
		LocalTime startTime1 = cd.getTime();
		LocalTime endTime1 = cd.getEndTime();
		LocalTime startTime2 = this.getTime();
		LocalTime endTime2 = this.getEndTime();
		
		// Check if the times clash
		if (startTime1.equals(startTime2))
			return true;
		if (startTime1.isBefore(startTime2) && endTime1.isAfter(startTime2))
			return true;
		if (startTime2.isBefore(startTime1)	&& endTime2.isAfter(startTime1))
			return true;

		return false;
	}

	/**
	 * 
	 * @param delimiter delimiter to separate elements of the class details
	 * @return a string representation of the class
	 */
	public String export(String delimiter) {
		return String.join(delimiter, this.getName(), 
				this.getDay().getDisplayName(TextStyle.FULL, Locale.getDefault()).toUpperCase(),
				this.getTime().toString(), this.getLocation(),
				new String("" + this.getDuration().toMinutes()));
	}
	
}
