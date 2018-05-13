package model;

/**
 * The state of a class instance
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public class ClassStatus {

	/**	Staff member assigned to the class	*/
	private String assignedStaff;
	/**	Whether the class is assigned or not	*/
	private boolean assigned;
	/**	Whether the staff assignment for the class is approved	*/
	private boolean approved;
	/**	whether the assigned staff member has accepted the assignment offer	*/
	private boolean accepted;

	public ClassStatus() {
		assignedStaff = null;
		setUnassigned();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStaff() { 
		if (assignedStaff == null)
			return "unassigned";
		return assignedStaff; 
	}
	
	/**
	 * @param staffID userID of the staff member to assign to this class
	 */
	public boolean assignStaff(String staffID) {
		setAssigned(staffID);
		
		return true;
	}
	
	/**
	 * approves the staff allocation
	 * 
	 * @return returns true if successful
	 */
	public boolean approve() {
		if (!assigned)
			return false;
		
		setApproved();
		return true;
	}
	
	/**
	 * Disapproves the staff allocation
	 * 
	 * @return returns true if successful
	 */
	public boolean disapprove() {
		if (!assigned)
			return false;
		
		setUnassigned();

		return true;
	}

	/**
	 * accepts the staff assignment offer
	 * 
	 * @param staffID userID of the staff member accepting the assignment offer
	 * 
	 * @return true is successful
	 */
	public boolean accept(String staffID) {
		if (approved && assignedStaff.compareTo(staffID) == 0) {
			setAccepted();
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
			setUnassigned();
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return whether the class is assigned or not
	 */
	public boolean isAssigned() { return assigned; }

	/**
	 * 
	 * @return whether the class is approved or not
	 */
	public boolean isApproved() { return this.approved; }

	/**
	 * 
	 * @return whether the sessional staff member has accepted their offer
	 */
	public boolean isAccepted() { return this.accepted; }
	
	/**
	 * 
	 * @return a string representation of the class status
	 */
	public String export() {
		String assignStr = new String();
		String approveStr = new String();
		String acceptStr = new String();
		
		if (assigned)
			assignStr += "true";
		else 
			assignStr += "false";
		
		if (approved)
			approveStr += "true";
		else 
			approveStr += "false";
		
		if (accepted)
			acceptStr += "true";
		else 
			acceptStr += "false";
		
		return String.join(",", this.getStaff(), assignStr, approveStr, acceptStr);
	}
	
	/**
	 * Sets the class state to unassigned
	 */
	private void setUnassigned() {
		assignedStaff = new String("unassigned");
		assigned = false;
		approved = false;
		accepted = false;
	}
	
	/**
	 * Sets the class state to assigned
	 */
	private void setAssigned(String assignedStaff) {
		this.assignedStaff = assignedStaff;
		assigned = true;
		approved = false;
		accepted = false;
	}
	
	/**
	 * Sets the class state to approved
	 */
	private void setApproved() {
		assigned = true;
		approved = true;
		accepted = false;
	}
	
	/**
	 * Sets the class state to accepted
	 */
	private void setAccepted() {
		assigned = true;
		approved = true;
		accepted = true;
	}

}
