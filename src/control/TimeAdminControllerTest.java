package control;

import static org.junit.Assert.*;

import org.junit.*;

public class TimeAdminControllerTest {

	private TimeAdminController cont;
	
	@Before
	public void setUp() throws Exception {
		cont = new TimeAdminController("e00003");
		assertNotNull(cont);
	}

	@Test
	public void testCreateStaff() {
		String retStr = 
				cont.getDatabase().createStaff("e012234", "password", null, null, 2, "SEF");
		
		assertArrayEquals(
				new String(),
				new String("Create Staff Successful: e012234 2").toCharArray(),
				retStr.toCharArray());
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
