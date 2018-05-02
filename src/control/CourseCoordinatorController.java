package control;

public class CourseCoordinatorController extends StaffController {
	
	private static final String VIEW_COURSE_TIMETABLE = "ViewCourseTimetable";
	
	public CourseCoordinatorController(String ID) {
		super(ID);
	}

	@Override
	public void getCommands() {
		boolean running = true;
		
		while (running) {
		
			
			switch (getInput().toLowerCase()) {
				case "exit":
					running = false;
					break;
				
				case "assignclass":
					assignClass();
					break;
				
				case "geteligiblestaff":
					getEligibleStaff();
					break;
				
				case "getunassignedclasses":
					getUnassignedClasses();
					break;
			}
			
		}
		
	}
	

}
