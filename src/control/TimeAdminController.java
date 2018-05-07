package control;

public class TimeAdminController extends StaffController {

	private static final String INPUT_TIMETABLE_DATA = "inputtimetabledata";
	private static final String CREATE_STAFF = "createstaff";
	private static final String CALL_REPORTS = "callreports";
	private static final String VIEW_COURSE_TIMETABLE = "timetable";
	private static final String VIEW_ELIGIBLE_STAFF = "eligiblestaff";
	private static final String ASSIGN_STAFF_TO_CLASS = "assignstaff";
	private static final String EDIT_CLASS = "editclass";
	private static final String APPROVE_STAFF_ASSIGNMENT = "approvestaff";
	private static final String VIEW_PENDING_APPROVALS = "approvals";
	private static final String EXIT = "exit";
	private static final String LOGOUT = "logout";
	private static final String VIEW_COMMANDS = "commands";
	
	public TimeAdminController(String userID) {
		super(userID);
	}
	
	private void viewCommands() {
		super.viewCommands(	INPUT_TIMETABLE_DATA + "\n" +
							CREATE_STAFF + "\n" +
							CALL_REPORTS + "\n" +
							VIEW_COURSE_TIMETABLE + "\n" +
							VIEW_ELIGIBLE_STAFF + "\n" +
							ASSIGN_STAFF_TO_CLASS + "\n" +
							EDIT_CLASS + "\n" +
							APPROVE_STAFF_ASSIGNMENT + "\n" +
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
					exit();
					break;
					
				case LOGOUT:
					running = false;
					break;
					
				case VIEW_COMMANDS:
					viewCommands();
					break;
				
				case INPUT_TIMETABLE_DATA:
					inputTimetableData();
					break;
					
				case CREATE_STAFF:
					createStaff();
					break;
					
				case CALL_REPORTS:
					//callReports();
					break;
				
				case ASSIGN_STAFF_TO_CLASS:
					assignStaffToClass();
					break;
				
				case VIEW_ELIGIBLE_STAFF:
					viewEligibleStaff();
					break;
				
				case VIEW_COURSE_TIMETABLE:
					//viewCourseTimetable();
					break;
				
				case EDIT_CLASS:
					editClass();
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
	
	@Override
	public void welcome() {
		super.welcome();
		viewCommands();
	}

}
