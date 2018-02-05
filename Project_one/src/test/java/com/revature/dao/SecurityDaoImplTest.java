package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecurityDaoImplTest {

	@Test
	public void testCheck_AccountNumber() {
		SecurityDaoImpl tester = new SecurityDaoImpl();
		assertEquals(false,tester.check_AccountNumber(3214));
	}

	

}
