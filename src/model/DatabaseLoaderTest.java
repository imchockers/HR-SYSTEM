package model;

import static org.junit.Assert.*;
import org.junit.*;
import java.io.FileNotFoundException;


public class DatabaseLoaderTest {

	MasterTimetable tt;
	StaffDatabase staffDb;
	
	@Before
	public void setUp() throws Exception {
		tt = DatabaseLoader.loadTimetable();
		assertNotNull(tt);
		staffDb = DatabaseLoader.loadStaff();
		assertNotNull(staffDb);
	}

	@Test (expected=FileNotFoundException.class)
	public void testLoadTimetable() throws FileNotFoundException {
		DatabaseLoader.loadTimetable("pathtonothing");
	}

	@Test (expected=FileNotFoundException.class)
	public void testLoadStaff() throws FileNotFoundException {
		DatabaseLoader.loadStaff("pathtonothing");
	}
	
	@After
	public void tearDown() throws Exception {
		DatabaseLoader.save(tt.export(), staffDb.export());
	}

}
