package control;

public class SessionalController extends StaffController {

	public SessionalController(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	
	private void viewCommands() {
		super.viewCommands(	VIEW_SESSIONAL_TIMETABLE_DESC + BUFFER + VIEW_TIMETABLE + "\n" +
							SUBMIT_AVAILABILITIES_DESC + BUFFER + SUBMIT_AVAILABILITIES + "\n" +
							VIEW_OFFERS_DESC + BUFFER + VIEW_OFFERS + "\n" +
							ACCEPT_OFFER_DESC + BUFFER + ACCEPT_OFFER + "\n" +
							REJECT_OFFER_DESC + BUFFER + REJECT_OFFER);
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
				
				case VIEW_TIMETABLE:
					viewSessionalTimetable();
					break;
				
				case SUBMIT_AVAILABILITIES:
					submitAvailabilities();
					break;
				
				case VIEW_OFFERS:
					viewOffers();
					break;
				
				case ACCEPT_OFFER:
					acceptOffer();
					break;
					
				case REJECT_OFFER:
					rejectOffer();
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
