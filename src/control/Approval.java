package control;

import model.Data;
import view.ConsoleView;

/**
 * Approval interface, contains default approval methods
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public interface Approval {

	/**
	 * Presents a view of a list of pending staff assignment approvals
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 */
	public default void viewPendingApprovals(ConsoleView privateView, Data db) {
		privateView.println("Current Saff Assignments Awaiting Approval:");
		privateView.println(db.getPendingApprovals() + "\n");
	}
	
	/**
	 * Gets input from a user and approves a specified class staff assignment
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 */
	public default void approveStaffAssignment(ConsoleView privateView, Data db) {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));

		if(db.approveStaffAssignment(classID))
			privateView.println("Approval Successful!" + "\n");
		else
			privateView.println("Approval Failed!" + "\n");
	}
	
	/**
	 * Gets input from a user and disapproves a specified class staff assignment
	 * 
	 * @param privateView view to output to
	 * @param db database to query
	 */
	public default void disapproveStaffAssignment(ConsoleView privateView, Data db) {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));

		if(db.disapproveStaffAssignment(classID))
			privateView.println("Disapproval Successful!" + "\n");
		else
			privateView.println("Disapproval Failed!" + "\n");
	}
	
}
