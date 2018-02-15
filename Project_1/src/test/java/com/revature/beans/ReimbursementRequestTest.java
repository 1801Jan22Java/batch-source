package com.revature.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReimbursementRequestTest {

	@Test
	public void testNoArgsConstructor() {
		ReimbursementRequest req = new ReimbursementRequest();
		
		assertEquals(0, req.getId());
		assertEquals(0, req.getAmount());
		assertEquals(0, req.getEmplId());
		assertEquals(0, req.getManagerId());
		
	}

}
