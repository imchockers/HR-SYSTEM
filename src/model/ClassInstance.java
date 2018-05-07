package model;

public class ClassInstance {

	/**	Counter of current number of classInstances, used to set classID	*/
	private static int classCount = 0;
	/**	Unique ID of the classInstance	*/
	private int classID;
	/**	Contains time, day, and location details	*/
	private ClassDetails details;
	/**	Contains details about the ClassInstance's current state	*/
	private ClassStatus status;
	
	/**
	 * Default constructor
	 * 
	 * @param name ClassInstance name.
	 */
	ClassInstance(String name) {
		this.classID = classCount;
		status = new ClassStatus();
		
		details = new ClassDetails(name);
		
		classCount++;
	}

	/**
	 * 
	 * @return The unique ID of the classInstance
	 */
	public int getClassID() { return classID; }
	
	/**
	 * 
	 * @return The time and date details of the classInstance
	 */
	public ClassDetails getDetails() { return details; }
	
	public ClassStatus getStatus() { return status; }

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
							details.export(", ") + ", " + 
							status.getStaff() + "\n"	);
	}

	
	public String export() {		
		return String.join(",", details.export(","), status.export());
	}
}
