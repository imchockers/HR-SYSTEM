package control;

public class SessionalController extends StaffController {

	private static final String VIEW_SESSIONAL_TIMETABLE = "viewsessionaltimetable";
	private static final String SUBMIT_AVAILABILITIES = "submitavailabilities";
	private static final String VIEW_OFFERS = "viewoffers";
	private static final String ACCEPT_OFFER = "acceptoffer";
	private static final String REJECT_OFFER = "rejectoffer";
	private static final String EXIT = "exit";
	private static final String VIEW_COMMANDS = "viewcommands";
	
	public SessionalController(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	
	private void viewCommands() {
		super.viewCommands(	VIEW_SESSIONAL_TIMETABLE + "\n" +
							SUBMIT_AVAILABILITIES + "\n" +
							VIEW_OFFERS + "\n" +
							ACCEPT_OFFER + "\n" +
							REJECT_OFFER + "\n" +
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
				
				case VIEW_SESSIONAL_TIMETABLE:
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

}
