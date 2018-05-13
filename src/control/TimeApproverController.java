package control;

/**
 * Controller used by course coordinator staff members upon login
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public class TimeApproverController extends StaffController implements Approval {
	
	/**
	 * Default constructor
	 * 
	 * @param ID userID of the staff member
	 */
	public TimeApproverController(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Prints commands available to this controller
	 * 
	 */
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
					approveStaffAssignment(getView(), getDatabase());
					break;
					
				case DISAPPROVE_STAFF_ASSIGNMENT:
					disapproveStaffAssignment(getView(), getDatabase());
					break;
				
				case VIEW_PENDING_APPROVALS:
					viewPendingApprovals(getView(), getDatabase());
					break;

			}
			
		}
		
	}
	
	@Override
	public void welcome() {
		super.welcome();
		viewCommands();
		viewPendingApprovals(getView(), getDatabase());
	}
	
}
