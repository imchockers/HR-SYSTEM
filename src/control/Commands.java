package control;

/**
 * All default command string formats and descriptions
 * 
 * @date 13/5/2018
 * 
 * @author Lachlan Clulow s3682356
 * @author Yazeed Othman s3543535
 * @author Lee Enders s3659667
 * @author Patrick Tria s3602866
 *
 */
public interface Commands {

	public static final String VIEW_TIMETABLE = "timetable";
	public static final String VIEW_COURSE_TIMETABLE_DESC = "View Course Timetable:";
	public static final String VIEW_SESSIONAL_TIMETABLE_DESC = "View Sessional Timetable:";
	public static final String VIEW_ELIGIBLE_STAFF = "eligiblestaff";
	public static final String VIEW_ELIGIBLE_STAFF_DESC = "View List Of Eligible Staff:";
	public static final String ASSIGN_STAFF_TO_CLASS = "assignstaff";
	public static final String ASSIGN_STAFF_TO_CLASS_DESC = "Assign A Staff Member To A Class:";
	public static final String EDIT_CLASS = "editclass";
	public static final String EDIT_CLASS_DESC = "Edit A Class' Details:";
	public static final String EXIT = "exit";
	public static final String EXIT_DESC = "Save/Logout and Exit Program:";
	public static final String LOGOUT = "logout";
	public static final String LOGOUT_DESC = "Logout of Account:";
	public static final String VIEW_COMMANDS = "commands";
	public static final String VIEW_COMMANDS_DESC = "View a List of Valid Commands";
	public static final String BUFFER = "\t";
	public static final String APPROVE_STAFF_ASSIGNMENT = "approvestaff";
	public static final String APPROVE_STAFF_ASSIGNMENT_DESC = "Approve the Staff Allocation of a Class:";
	public static final String DISAPPROVE_STAFF_ASSIGNMENT = "disapprovestaff";
	public static final String DISAPPROVE_STAFF_ASSIGNMENT_DESC = "Disapprove the Staff Allocation of a Class:";
	public static final String VIEW_PENDING_APPROVALS = "viewapprovals";
	public static final String VIEW_PENDING_APPROVALS_DESC = "View a List of Pending Staff Approvals:";
	public static final String INPUT_TIMETABLE_DATA = "inputtimetabledata";
	public static final String INPUT_TIMETABLE_DATA_DESC = "Input a new Discipline/Course/Class Into the Timetable:";
	public static final String CREATE_STAFF = "createstaff";
	public static final String CREATE_STAFF_DESC = "Create a New Staff Member:";
	public static final String CALL_REPORTS = "callreports";
	public static final String CALL_REPORTS_DESC = "Call Reports:";
	public static final String SUBMIT_AVAILABILITIES = "submitavailabilities";
	public static final String SUBMIT_AVAILABILITIES_DESC = "Submit Work Availabilities:";
	public static final String VIEW_OFFERS = "offers";
	public static final String VIEW_OFFERS_DESC = "View a List of Job Offers:";
	public static final String ACCEPT_OFFER = "acceptoffer";
	public static final String ACCEPT_OFFER_DESC = "Accept a Job Offer:";
	public static final String REJECT_OFFER = "rejectoffer";
	public static final String REJECT_OFFER_DESC = "Reject a Job Offer:";

}
