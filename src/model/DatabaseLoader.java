package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DatabaseLoader {
	
	private static final String LOGIN_DATA = "login.data";
	private static final String TIMETABLE_DATA = "timetable.data";
	
	public static MasterTimetable loadTimetable() {
		MasterTimetable ttDb = new MasterTimetable();
		
		Scanner sc;
		File fp = new File(TIMETABLE_DATA);
		
		try {
			sc = new Scanner(fp);
			
			sc.nextLine();
			
			String fileInput = sc.nextLine();
			
			while (fileInput != null) {
				try {
					String[] elements = fileInput.split(",");
				
					int classID = ttDb.inputTimetableData(elements[0], elements[1], elements[2]);
					
					ttDb.editClass(classID, elements[3], elements[4], elements[5], Integer.parseInt(elements[7]));
				
					if (!(elements[6].compareTo("unassigned") == 0)) {
						if (elements[8].compareTo("true") == 0)
							ttDb.assignStaffToClass(elements[6], classID);
						if (elements[9].compareTo("true") == 0)
							ttDb.approveStaffAssignment(classID);
						if (elements[10].compareTo("true") == 0)
							ttDb.acceptOffer(classID, elements[6]);
					}
					
					fileInput = sc.nextLine();
				} catch (NoSuchElementException e) {
					break;
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.exit(0);
		}

		return ttDb;
	}

	public static StaffDatabase loadStaff() {
		StaffDatabase sDb = new StaffDatabase();
		
		Scanner sc;
		File fp = new File(LOGIN_DATA);
		
		try {
			sc = new Scanner(fp);
			
			sc.nextLine();
			
			String fileInput = sc.nextLine();
			
			while (fileInput != null) {
				try {
					String[] elements = fileInput.split(",");
					sDb.createStaff(elements[0], elements[1], elements[2], elements[3], Integer.parseInt(elements[4]), elements[5]);
					fileInput = sc.nextLine();
				} catch (NoSuchElementException e) {
					break;
				}
			}
			
			sc.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.exit(0);
		}
		

		return sDb;
	}
	
	public static boolean saveTimetable(String data) {
		try {
			PrintWriter writer = new PrintWriter("timetable.data", "UTF-8");
			
			writer.println("Discipline,Course,Class Name,Day,Time,Location,Staff ID,Duration,Assigned,Approved,Accepted");
			
			writer.print(data);
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean saveStaffData(String data) {
		try {
			PrintWriter writer = new PrintWriter("login.data", "UTF-8");
			
			writer.println("User ID,Password,Qualifications,Availabilities,Privilege,Course Name");
			writer.print(data);
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
	
		return true;
	}

	public static String save(String ttData, String staffData) {
		String retStr = new String();
		
		if (saveTimetable(ttData))
			retStr += "Timetable data saved correctly! ";
		else
			retStr += "Timetable data may not have saved! ";
		
		if (saveStaffData(staffData))
			retStr += "Staff data saved correctly!";
		else
			retStr += "Staff data may not have saved!";
		
		return retStr;

	}
	

}
