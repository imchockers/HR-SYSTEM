package control;

public class CourseCoordinatorController extends StaffController {
	
	private static final String VIEW_COURSE_TIMETABLE = "viewcoursetimetable";
	private static final String VIEW_ELIGIBLE_STAFF = "vieweligiblestaff";
	private static final String ASSIGN_STAFF_TO_CLASS = "assignstafftoclass";
	private static final String EDIT_CLASS = "editclass";
	private static final String EXIT = "exit";
	private static final String VIEW_COMMANDS = "viewcommands";
	
	
	public CourseCoordinatorController(String ID) {
		super(ID);
	}
	
	private void viewCommands() {
		super.viewCommands(	VIEW_COURSE_TIMETABLE + "\n" +
							VIEW_ELIGIBLE_STAFF + "\n" +
							ASSIGN_STAFF_TO_CLASS + "\n" +
							EDIT_CLASS + "\n" +
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
				
				case ASSIGN_STAFF_TO_CLASS:
					assignStaffToClass();
					break;
				
				case VIEW_ELIGIBLE_STAFF:
					viewEligibleStaff();
					break;
				
				case VIEW_COURSE_TIMETABLE:
					viewCourseTimetable();
					break;
				
				case EDIT_CLASS:
					editClass();
					break;

			}
			
		}
		
	}
	

}
