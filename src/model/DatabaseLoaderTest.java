package model;

import static org.junit.Assert.*;
import org.junit.*;
import java.io.FileNotFoundException;


public class DatabaseLoaderTest {

	MasterTimetable tt;
	StaffDatabase staffDb;
	
	/**	Tests that the database can load both staff and timetable data	*/
	@Before
	public void setUp() throws Exception {
		tt = DatabaseLoader.loadTimetable();
		assertNotNull(tt);
		staffDb = DatabaseLoader.loadStaff();
		assertNotNull(staffDb);
	}

	/**	Tests that DatabaseLoader fails as expected with the incorrect filepath	*/
	@Test (expected=FileNotFoundException.class)
	public void testLoadTimetableFail() throws FileNotFoundException {
		DatabaseLoader.loadTimetable("pathtonothing");
	}
	
	/**	Tests that DatabaseLoader behaves as expected with the correct filepath	*/
	@Test
	public void testLoadTimetable() throws FileNotFoundException {
		assertNotNull(DatabaseLoader.loadTimetable("timetable.data"));
	}

	/**	Tests that DatabaseLoader fails as expected with the incorrect filepath	*/
	@Test (expected=FileNotFoundException.class)
	public void testLoadStaffFail() throws FileNotFoundException {
		DatabaseLoader.loadStaff("pathtonothing");
	}
	
	/**	Tests that DatabaseLoader behaves as expected with the correct filepath	*/
	@Test
	public void testLoadStaff() throws FileNotFoundException {
		assertNotNull(DatabaseLoader.loadStaff("login.data"));
	}
	
	/**	Tests that DatabaseLoader behaves as when saving data to file	*/
	@After
	public void tearDown() throws Exception {
		String retStr= DatabaseLoader.save(tt.export(), staffDb.export());
		
		assertArrayEquals(
				new String("Timetable data saved correctly! Staff data saved correctly!").toCharArray(),
				retStr.toCharArray());
	}

}
