package control;

public class TimeApproverController extends StaffController {

	private static final String APPROVE_STAFF_ASSIGNMENT = "approvestaff";
	private static final String VIEW_PENDING_APPROVALS = "viewapprovals";
	private static final String EXIT = "exit";
	private static final String VIEW_COMMANDS = "commands";
	
	public TimeApproverController(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	
	private void viewCommands() {
		super.viewCommands(	APPROVE_STAFF_ASSIGNMENT + "\n" +
							VIEW_PENDING_APPROVALS + "\n" +
							VIEW_COMMANDS + "\n" +
							EXIT);
	}

	@Override
	public void getCommands() {
		boolean running = true;
		
		while (running) {
		
			
			switch (getInput().toLowerCase()) {
				case EXIT:
					running = false;
					break;
					
				case VIEW_COMMANDS:
					viewCommands();
					break;
				
				case APPROVE_STAFF_ASSIGNMENT:
					approveStaffAssignment();
					break;
				
				case VIEW_PENDING_APPROVALS:
					viewPendingApprovals();
					break;

			}
			
		}
		
	}
	
}
