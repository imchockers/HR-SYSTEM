package control;

public class CourseCoordinatorController extends StaffController implements Coordination {
	
	private String courseName;
	
	public CourseCoordinatorController(String ID, String courseName) {
		super(ID);
		this.courseName = courseName;
	}
	
	private void viewCommands() {
		super.viewCommands( VIEW_COURSE_TIMETABLE_DESC + BUFFER + VIEW_TIMETABLE + "\n" +
							VIEW_ELIGIBLE_STAFF_DESC + BUFFER + VIEW_ELIGIBLE_STAFF + "\n" +
							ASSIGN_STAFF_TO_CLASS_DESC + BUFFER + ASSIGN_STAFF_TO_CLASS + "\n" +
							EDIT_CLASS_DESC + BUFFER + EDIT_CLASS);
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
				
				case ASSIGN_STAFF_TO_CLASS:
					assignStaffToClass(getView(), getDatabase());
					break;
				
				case VIEW_ELIGIBLE_STAFF:
					viewEligibleStaff(getView(), getDatabase(), courseName);
					break;
				
				case VIEW_TIMETABLE:
					viewCourseTimetable(getView(), getDatabase(), courseName);
					break;
				
				case EDIT_CLASS:
					editClass(getView(), getDatabase());
					break;

			}	
		}
	}
	
	@Override
	public void welcome() {
		super.welcome();
		viewCommands();
		viewCourseTimetable(getView(), getDatabase(), courseName);
		viewEligibleStaff(getView(), getDatabase(), courseName);
	}

}
