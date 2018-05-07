package control;

import model.Database;
import view.ConsoleView;

public interface Approval {

	public default void viewPendingApprovals(ConsoleView privateView, Database db) {
		privateView.println("Current Saff Assignments Awaiting Approval:");
		privateView.println(db.getPendingApprovals() + "\n");
	}
	
	public default void approveStaffAssignment(ConsoleView privateView, Database db) {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));

		if(db.approveStaffAssignment(classID))
			privateView.println("Approval Successful!" + "\n");
		else
			privateView.println("Approval Failed!" + "\n");
	}
	
	public default void disapproveStaffAssignment(ConsoleView privateView, Database db) {
		int classID = Integer.parseInt(privateView.getInput("Enter Class ID: "));

		if(db.disapproveStaffAssignment(classID))
			privateView.println("Disapproval Successful!" + "\n");
		else
			privateView.println("Disapproval Failed!" + "\n");
	}
	
}
