package model;

import static org.junit.Assert.*;
import org.junit.*;

import Exceptions.InvalidLoginException;

public class DataTest {

	static Data db;
	
	@BeforeClass
	public static void setUp() throws Exception {
		db = new Data();
	}

	@Test
	public void testValidLogIn() throws InvalidLoginException {
		db.logIn("e00001", "password");
	}
	
	@Test (expected=InvalidLoginException.class)
	public void testInvalidLogInID() throws InvalidLoginException {
		db.logIn("invalid", "password");
	}
	
	@Test (expected=InvalidLoginException.class)
	public void testInvalidLogInPassword() throws InvalidLoginException {
		db.logIn("e00001", "really_secure_password123");
	}

}
