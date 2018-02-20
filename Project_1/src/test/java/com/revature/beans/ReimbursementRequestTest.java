package com.revature.beans;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class ReimbursementRequestTest {

	@Test
	public void testNoArgsConstructor() {
		ReimbursementRequest req = new ReimbursementRequest();

		assertEquals(0, req.getId());
		assertEquals(0, req.getAmount(), 0.1);
		assertEquals(0, req.getEmplId());
		assertEquals(null, req.getDateReq());
		assertEquals(null, req.getDescription());
		assertEquals(null, req.getReceipt());
	}

	@Test
	public void testNoIdNoProcessedConstructor() {
		LocalDate dt = LocalDate.now();
		ReimbursementRequest req = new ReimbursementRequest(100, dt, 1, null,
				"description");

		assertEquals(0, req.getId());
		assertEquals(100, req.getAmount(), 0.1);
		assertEquals(1, req.getEmplId());
		assertEquals(dt, req.getDateReq());
		assertEquals("description", req.getDescription());
		assertEquals(null, req.getReceipt());
	}

	@Test
	public void testNoProcessedConstructor() {
		LocalDate dt = LocalDate.now();
		ReimbursementRequest req = new ReimbursementRequest(1, 100, dt, 1, null,
				"description");

		assertEquals(1, req.getId());
		assertEquals(100, req.getAmount(), 0.1);
		assertEquals(1, req.getEmplId());
		assertEquals(dt, req.getDateReq());
		assertEquals("description", req.getDescription());
		assertEquals(null, req.getReceipt());
	}

	@Test
	public void testSetters() {
		LocalDate dt1 = LocalDate.now();
		ReimbursementRequest req1 = new ReimbursementRequest(1, 100, dt1, 1,
				null, "description");
		ReimbursementRequest req2 = req1;
		LocalDate dt2 = LocalDate.now();

		assertEquals(req2, req1);

		req1 = req1.setAmount(150);
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setDateReq(dt2);
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setDescription("new description");
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setEmplId(2);
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setId(5);
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setReceipt(null);
		assertNotEquals(req1, req2);
		req2 = req1;

		assertEquals(5, req1.getId());
		assertEquals(150.0, req1.getAmount(), 0.1);
		assertEquals(2, req1.getEmplId());
		assertEquals(dt2, req1.getDateReq());
		assertEquals("new description", req1.getDescription());
		assertEquals(null, req1.getReceipt());

	}

}
