package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Exceptions.InvalidLoginException;

public class DataTest {

	Data db;
	
	@Before
	public void setUp() throws Exception {
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
