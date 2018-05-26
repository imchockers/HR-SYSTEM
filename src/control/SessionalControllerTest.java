/**
 * 
 */
package control;

import static org.junit.Assert.*;

import org.junit.*;

import Exceptions.InvalidLoginException;

/**
 * @author lachl
 *
 */
public class SessionalControllerTest {

	private SessionalController cont;

	@Before
	public void setUp() throws InvalidLoginException {
		cont = new SessionalController("e00003");
		assertNotNull(cont);
	}
	
	/**
	 * Test method for {@link control.StaffController#logIn()}.
	 * @throws InvalidLoginException 
	 */
	@Test
	public void testLogIn() throws InvalidLoginException {
		assertNotNull(cont.getDatabase().logIn("e00003", "password"));
	}
	
	/**
	 * Test method for {@link control.StaffController#logIn()}.
	 * @throws InvalidLoginException 
	 */
	@Test (expected=InvalidLoginException.class)
	public void testLogInFail() throws InvalidLoginException {
		cont.getDatabase().logIn("e00003", "passwor1d");
	}

	/**
	 * Test method for {@link control.SessionalController#acceptOffer()}.
	 */
	@Test
	public void testAcceptOffer() {
		assertTrue(cont.getDatabase().acceptOffer(1, "e00003"));
	}

	/**
	 * Test method for {@link control.SessionalController#rejectOffer()}.
	 */
	@Test
	public void testRejectOffer() {
		assertTrue(cont.getDatabase().acceptOffer(1, "e00003"));
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
