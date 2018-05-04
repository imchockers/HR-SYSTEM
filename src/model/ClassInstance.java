package model;

public class ClassInstance {

	/**	Counter of current number of classInstances, used to set classID	*/
	private static int classCount = 0;
	/**	Unique ID of the classInstance	*/
	private int classID;
	/**	ClassInstance name	*/
	private String name;
	/**	Classroom Location	*/
	private String location;
	/**	Time of day the class occurs 24hr time	*/
	private String time;
	/**	Day of the week the class occurs	*/
	private String day;
	/**	Whether the class is assigned or not	*/
	private boolean assigned;
	/**	Staff member assigned to the class	*/
	private String assignedStaff;
	/**	Whether the staff assignment for the class is approved	*/
	private boolean approved;
	/**	whether the assigned staff member has accepted the assignment offer	*/
	private boolean accepted;
	/**	duration of the class in minutes	*/
	private int duration;
	
	/**
	 * Default constructor
	 * 
	 * @param name ClassInstance name.
	 */
	ClassInstance(String name) {
		this.classID = classCount;
		this.name = name;
		this.assigned = false;
		this.approved = false;
		this.accepted = false;
		
		classCount++;
	}
	
	ClassInstance(String name, String time, String day, String location, String staffID, int duration) {
		this(name);
		this.time = time;
		this.day = day;
		this.location = location;
		this.assignedStaff = staffID;
		this.duration = duration;
	}
	
	/**
	 * 
	 * @return The ClassInstance name
	 */
	public String getName() { return name; }

	/**
	 * 
	 * @return The unique ID of the classInstance
	 */
	public int getClassID() { return classID; }
	
	/**
	 * @param staffID userID of the staff member to assign to this class
	 */
	public boolean assignStaff(String staffID) {
		this.assignedStaff = staffID;
		assigned = true;
		
		return true;
	}

	/**
	 * 
	 * @return whether the class is approved or not
	 */
	public boolean isApproved() { return this.approved; }

	/**
	 * sets the location element of the classInstance
	 * 
	 * @param location value to set the location to
	 */
	public void setLocation(String location) {
		if (location != null)
			this.location = location;
	}

	/**
	 * sets the time element of the classInstance
	 * 
	 * @param time value to set the time to
	 */
	public void setTime(String time) {
		if (time != null)
			this.time = time;
	}

	/**
	 * sets the day element of the classInstance
	 * 
	 * @param day value to set the day to
	 */
	public void setDay(String day) {
		if (day != null)
			this.day = day;
	}

	/**
	 * approves the staff allocation
	 * 
	 * @return returns true if successful
	 */
	public boolean approve() {
		if (!assigned)
			return false;
		
		approved = true;
		return true;
	}

	/**
	 * 
	 * @return whether the sessional staff member has accepted their offer
	 */
	public boolean isAccepted() { return this.accepted; }

	/**
	 * 
	 * @return the userID of the staff member assigned to the class
	 */
	public String getStaff() { return this.assignedStaff; }

	/**
	 * accepts the staff assignment offer
	 * 
	 * @param staffID userID of the staff member accepting the assignment offer
	 * 
	 * @return true is successful
	 */
	public boolean accept(String staffID) {
		if (approved && assignedStaff.compareTo(staffID) == 0) {
			accepted = true;
			return true;
		}
		return false;
	}

	/**
	 * rejects the staff assignment offer and resets the class assignment elements
	 * 
	 * @return true is successful
	 */
	public boolean reject(String staffID) {
		if (assignedStaff.compareTo(staffID) == 0) {
			assigned = false;
			accepted = false;
			approved = false;
			assignedStaff = new String("unassigned");
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @return the duration of the class in minutes
	 */
	public int getDuration() { return this.duration; }

	/**
	 * sets the value of the duration element of the class
	 * 
	 * @param duration duration of the class in minutes
	 */
	public void setDuration(int duration) {
		if (duration > 0)
			this.duration = duration;
	}
	
	/**
	 * @return 	Returns a string representation of the data contained in the
	 * 			classInstance in the format:
	 * 
	 * 			<name>, <day>, <time>, <location>, <assignedStaff>
	 * 
	 * 			Terminated by a newline.
	 */
	@Override
	public String toString() {
		
		return new String(	classID + ", " +
							name + ", " +
							day + ", " + 
							time + ", " + 
							location + ", " + 
							assignedStaff + "\n"	);
	}

	
	/**
	 * 
	 * @return whether the class is assigned or not
	 */
	public boolean isAssigned() { return assigned; }
}
