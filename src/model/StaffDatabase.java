package model;

import java.util.ArrayList;
import control.*;

public class StaffDatabase {

	private ArrayList<StaffMember> staff;

	StaffDatabase() {
		staff = new ArrayList<StaffMember>();
	}
	
	public StaffController login(String userID, String pwd) {
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
	
}
