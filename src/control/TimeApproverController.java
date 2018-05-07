package control;

public class TimeApproverController extends StaffController {
	
	public TimeApproverController(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	
	private void viewCommands() {
		super.viewCommands(	APPROVE_STAFF_ASSIGNMENT_DESC + BUFFER + APPROVE_STAFF_ASSIGNMENT + "\n" +
							VIEW_PENDING_APPROVALS_DESC + BUFFER + VIEW_PENDING_APPROVALS);
	}

	@Override
	public void getCommands() {
		boolean running = true;
		
		while (running) {
		
			
			switch (getInput().toLowerCase()) {
				case LOGOUT:
					running = false;
					break;
				
				case EXIT:
					exit();
					break;
					
				case VIEW_COMMANDS:
					viewCommands();
					break;
				
				case APPROVE_STAFF_ASSIGNMENT:
					approveStaffAssignment();
					break;
					
				case DISAPPROVE_STAFF_ASSIGNMENT:
					disapproveStaffAssignment();
					break;
				
				case VIEW_PENDING_APPROVALS:
					viewPendingApprovals();
					break;

			}
			
		}
		
	}
	
	@Override
	public void welcome() {
		super.welcome();
		viewCommands();
	}
	
}
