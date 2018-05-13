package control;

/**
 * Controller used by sessional staff members upon login
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public class SessionalController extends StaffController implements Commands {

	/**
	 * Default constructor
	 * 
	 * @param ID userID of the staff member
	 */
	public SessionalController(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Prints commands available to this controller
	 * 
	 */
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
		viewSessionalTimetable();
		viewOffers();
	}
	
	/**
	 * Prints a view of the current users timetable of assigned classes
	 */
	public void viewSessionalTimetable() {
		getView().println("Current Personal Timetable:");
		getView().println(getDatabase().getSessionalTimetable(getID()) + "\n");
	}
	
	/**
	 * Prints a list of pending offers of approved staff assignments to this user
	 */
	public void viewOffers() {
		getView().println("Pending Class Offers:");
		getView().println(getDatabase().getOffers(getID()) + "\n");
	}
	
	/**
	 * Accepts a pending offer
	 */
	public void acceptOffer() {
		int classID = Integer.parseInt(getView().getInput("Enter Class ID: "));
		
		if(getDatabase().acceptOffer(classID, getID()))
			getView().println("Offer Accepted Successfully!" + "\n");
		else
			getView().println("Offer Accept Failed!" + "\n");
	}
	
	/**
	 * rejects a pending offer
	 */
	public void rejectOffer() {
		int classID = Integer.parseInt(getView().getInput("Enter Class ID: "));
		
		if(getDatabase().rejectOffer(classID, getID()))
			getView().println("Offer Rejected Successfully!" + "\n");
		else
			getView().println("Offer Reject Failed!" + "\n");
		
	}
	
	public void submitAvailabilities() {
		String availabilities = getView().getInput("Enter Availabilities Name (<day>/<start-time 24hrs XXXX>-<end-time 24hrs XXXX>~<day>/<start-time 24hrs XXXX>-<end-time 24hrs XXXX>...): ");
		
		getDatabase().setAvailabilities(getID(), availabilities);
	}

}
