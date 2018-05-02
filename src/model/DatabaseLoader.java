package model;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DatabaseLoader {
	
	private static final String LOGIN_DATA = "model/login.data";
	private static final String TIMETABLE_DATA = "model/timetable.data";
	
	public static TimetableDatabase loadTimetable() {
		TimetableDatabase ttDb = new TimetableDatabase();
		
		Scanner sc;
		sc = new Scanner(ClassLoader.getSystemResourceAsStream(TIMETABLE_DATA));
		
		String fileInput = sc.nextLine();
		
		while (fileInput != null) {
			try {
				String[] elements = fileInput.split(",");
			
				ttDb.addClass(elements[0], elements[1], elements[2]);
			
				System.out.println("Loaded class: " + elements[0] + " " + elements[1] + " " + elements[2]);
			
				fileInput = sc.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
		}
		
		sc.close();

		return ttDb;
	}

	public static StaffDatabase loadStaff() {
		StaffDatabase sDb = new StaffDatabase();
		
		Scanner sc;
		sc = new Scanner(ClassLoader.getSystemResourceAsStream(LOGIN_DATA));
		
		String fileInput = sc.nextLine();
		
		while (fileInput != null) {
			try {
				String[] elements = fileInput.split(",");
			
				sDb.addStaff(elements[0], elements[1], Integer.parseInt(elements[2]), elements[3]);
			
				System.out.println("Loaded Staff Member: " + elements[0]);
			
				fileInput = sc.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
		}
		
		sc.close();

		return sDb;
	}

}
