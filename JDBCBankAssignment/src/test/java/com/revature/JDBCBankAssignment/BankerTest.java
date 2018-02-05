package com.revature.JDBCBankAssignment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.JDBCBankAssignment.Banker;

public class BankerTest {

	Banker banker;
	
	@Before
	public void init() {
		banker = new Banker();
	}
	
	@Test
	public void initTest() {
		assertTrue(banker.init());
	}

}
