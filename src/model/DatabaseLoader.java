package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DatabaseLoader {
	
	private static final String LOGIN_DATA = "login.data";
	private static final String TIMETABLE_DATA = "timetable.data";
	
	public static MasterTimetable loadTimetable() throws FileNotFoundException {
		return loadTimetable(TIMETABLE_DATA);
	}
	
	public static MasterTimetable loadTimetable(String path) throws FileNotFoundException {
		MasterTimetable ttDb = new MasterTimetable();
		
		Scanner sc;
		File fp = new File(path);
		
		sc = new Scanner(fp);
		
		sc.nextLine();
		
		String fileInput = sc.nextLine();
		
		while (fileInput != null) {
			try {
				String[] elements = fileInput.split(",");
			
				int classID = ttDb.inputTimetableData(elements[0], elements[1], elements[2]);
				
				ttDb.editClass(classID, elements[5], LocalTime.parse(elements[4]), DayOfWeek.valueOf(elements[3]), Duration.parse("PT" + elements[6] + "M"));
			
				if (elements[7].compareTo("unassigned") != 0) {
					if (elements[8].compareTo("true") == 0)
						ttDb.assignStaffToClass(elements[7], classID);
					if (elements[9].compareTo("true") == 0)
						ttDb.approveStaffAssignment(classID);
					if (elements[10].compareTo("true") == 0)
						ttDb.acceptOffer(classID, elements[7]);
				}
				
				fileInput = sc.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
		}
		
		sc.close();

		return ttDb;
	}

	public static StaffDatabase loadStaff() throws FileNotFoundException {
		return loadStaff(LOGIN_DATA);
	}
	
	public static StaffDatabase loadStaff(String path) throws FileNotFoundException {
		StaffDatabase sDb = new StaffDatabase();
		
		Scanner sc;
		File fp = new File(path);
		
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
		

		return sDb;
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

	private static boolean saveTimetable(String data) {
		try {
			PrintWriter writer = new PrintWriter("timetable.data", "UTF-8");
			
			writer.println("Discipline,Course,Class Name,Day,Time,Location,Duration,Staff ID,Assigned,Approved,Accepted");
			
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
	
	private static boolean saveStaffData(String data) {
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
	

}
