package control;

public class TimeAdminController extends StaffController implements Approval, Coordination {
	
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
					assignStaffToClass(getView(), getDatabase());
					break;
				
				case VIEW_ELIGIBLE_STAFF:
					viewEligibleStaff();
					break;
				
				case VIEW_TIMETABLE:
					//viewCourseTimetable();
					break;
				
				case EDIT_CLASS:
					editClass(getView(), getDatabase());
					break;

				case APPROVE_STAFF_ASSIGNMENT:
					approveStaffAssignment(getView(), getDatabase());
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
	
	public void inputTimetableData() {
		String discipline = getView().getInput("Enter Discipline Name: ");
		String course = getView().getInput("Enter Course Name: ");
		String className = getView().getInput("Enter Class Name: ");
		
		int classID = getDatabase().inputTimetableData(discipline, course, className);
		
		editClass(getView(), getDatabase(), classID);
		
		getView().println("New Class Added! ID: " + classID + "\n");
	}
	
	public void createStaff() {
		String userID = getView().getInput("Enter new staff UserID: ");
		String pwd = getView().getInput("Enter Password (>=8 characters): ");
		int privilege = 0;
		String courseName = "";
		
		try {
			privilege = Integer.parseInt(getView().getInput("Enter Privilege Level (0-3): "));
		} catch (NumberFormatException e) {
			getView().println("NumberFormatException: Enter an integer." + "\n");
			return;
		}
		
		if (privilege == 2)
			courseName = getView().getInput("Enter Course Name: ");
		
		getView().println(getDatabase().createStaff(userID, pwd, null, null, privilege, courseName) + "\n");
	}
	
	public void viewEligibleStaff() {
		String courseName = getView().getInput("Enter Course Name: ");

		viewEligibleStaff(getView(), getDatabase(),  courseName);
	}

}
