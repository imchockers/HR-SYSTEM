package model;

import java.util.ArrayList;
import control.*;

public class StaffDatabase implements AccessStaffDatabase {

	private ArrayList<StaffMember> staff;

	StaffDatabase() {
		staff = new ArrayList<StaffMember>();
	}
	
	public StaffController logIn(String userID, String pwd) {
		for (StaffMember s: staff)
			if (s.compareID(userID) && s.comparePwd(pwd)) {
				System.out.println("Valid Login");
				return createController(s.getID(), s.getPrivilege());
			}
		System.out.println("Invalid Login");
		return null;
	}
	
	private StaffController createController(String ID, int privilege) {
		switch (privilege) {
			case 0: return new SessionalController(ID);
			
			case 1: return new TimeApproverController(ID);
			
			case 2: return new CourseCoordinatorController(ID);
			
			case 3: return new TimeAdminController(ID);
		}
		return null;
	}

	public void addStaff(String userID, String pwd, int privilege) {
		staff.add(new StaffMember(userID, pwd, privilege));
	}

	public ArrayList<StaffMember> getData() { return staff; }

	public String createStaff(String userID, String pwd, int privilege) {
		String failureReason = null;
		
		if (staffExists(userID)) {
			failureReason = new String("Staff Member Exists!");
		}
		else if (pwd.length() < 8) {
			failureReason = new String("Password Insecure!");
		}
		else if (privilege < 0 && privilege > 3) {
			failureReason = new String("Invalid Privilege Level!");
		}
		
		if (failureReason != null)
			return new String("Create Staff failed: " + failureReason);
		
		addStaff(userID, pwd, privilege);
		
		return new String("Create Staff Successful: " + userID + " " + privilege);
		
	}

	@Override
	public void viewEligibleStaff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submitAvailabilities() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewStaffMember() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean staffExists(String userID) {
		for (StaffMember s: staff) {
			if (s.compareID(userID))
				return true;
		}
		
		return false;
	}

	@Override
	public String createStaff() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
