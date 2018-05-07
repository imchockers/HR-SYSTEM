package control;

public class TimeAdminController extends StaffController {
	
	public TimeAdminController(String userID) {
		super(userID);
	}
	
	private void viewCommands() {
		super.viewCommands(	INPUT_TIMETABLE_DATA_DESC + BUFFER + INPUT_TIMETABLE_DATA + "\n" +
							CREATE_STAFF_DESC + BUFFER + CREATE_STAFF + "\n" +
							CALL_REPORTS_DESC + BUFFER + CALL_REPORTS + "\n" +
							VIEW_COURSE_TIMETABLE_DESC + BUFFER + VIEW_TIMETABLE + "\n" +
							VIEW_ELIGIBLE_STAFF_DESC + BUFFER + VIEW_ELIGIBLE_STAFF + "\n" +
							ASSIGN_STAFF_TO_CLASS_DESC + BUFFER + ASSIGN_STAFF_TO_CLASS + "\n" +
							EDIT_CLASS_DESC + BUFFER + EDIT_CLASS + "\n" +
							APPROVE_STAFF_ASSIGNMENT_DESC + BUFFER + APPROVE_STAFF_ASSIGNMENT + "\n" +
							VIEW_PENDING_APPROVALS_DESC + BUFFER + VIEW_PENDING_APPROVALS);
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
				
				case VIEW_TIMETABLE:
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
		viewPendingApprovals();
	}

}
