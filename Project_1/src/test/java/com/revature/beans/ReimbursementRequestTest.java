package com.revature.beans;

import static org.junit.Assert.*;


import java.time.LocalDateTime;


import org.junit.Test;

public class ReimbursementRequestTest {

	@Test
	public void testNoArgsConstructor() {
		ReimbursementRequest req = new ReimbursementRequest();

		assertEquals(0, req.getId());
		assertEquals(0, req.getAmount(), 0.1);
		assertEquals(0, req.getEmplId());
		assertEquals(0, req.getManagerId());
		assertEquals(null, req.getDatePro());
		assertEquals(null, req.getDateReq());
		assertEquals(null, req.getDescription());
		assertEquals(null, req.getReceipt());
		assertEquals(null, req.getStatus());
	}

	@Test
	public void testNoIdNoProcessedConstructor() {
		LocalDateTime dt = LocalDateTime.now();
		ReimbursementRequest req = new ReimbursementRequest(100, dt, 1, null,
				"description");

		assertEquals(0, req.getId());
		assertEquals(100, req.getAmount(), 0.1);
		assertEquals(1, req.getEmplId());
		assertEquals(0, req.getManagerId());
		assertEquals(null, req.getDatePro());
		assertEquals(dt, req.getDateReq());
		assertEquals("description", req.getDescription());
		assertEquals(null, req.getReceipt());
		assertEquals(null, req.getStatus());
	}

	@Test
	public void testNoProcessedConstructor() {
		LocalDateTime dt = LocalDateTime.now();
		ReimbursementRequest req = new ReimbursementRequest(1, 100, dt, 1, null,
				"description");

		assertEquals(1, req.getId());
		assertEquals(100, req.getAmount(), 0.1);
		assertEquals(1, req.getEmplId());
		assertEquals(0, req.getManagerId());
		assertEquals(null, req.getDatePro());
		assertEquals(dt, req.getDateReq());
		assertEquals("description", req.getDescription());
		assertEquals(null, req.getReceipt());
		assertEquals(null, req.getStatus());
	}

	@Test
	public void testNoIdConstructor() {
		LocalDateTime dt = LocalDateTime.now();
		ReimbursementRequest req = new ReimbursementRequest(100, dt, 1, null,
				"description", RequestStatus.APPROVED, 3, dt);

		assertEquals(0, req.getId());
		assertEquals(100, req.getAmount(), 0.1);
		assertEquals(1, req.getEmplId());
		assertEquals(3, req.getManagerId());
		assertEquals(dt, req.getDatePro());
		assertEquals(dt, req.getDateReq());
		assertEquals("description", req.getDescription());
		assertEquals(null, req.getReceipt());
		assertEquals(RequestStatus.APPROVED, req.getStatus());
	}

	@Test
	public void testFullConstructor() {
		LocalDateTime dt = LocalDateTime.now();
		ReimbursementRequest req = new ReimbursementRequest(1, 100, dt, 1, null,
				"description", RequestStatus.APPROVED, 3, dt);

		assertEquals(1, req.getId());
		assertEquals(100.0, req.getAmount(), 0.1);
		assertEquals(1, req.getEmplId());
		assertEquals(3, req.getManagerId());
		assertEquals(dt, req.getDatePro());
		assertEquals(dt, req.getDateReq());
		assertEquals("description", req.getDescription());
		assertEquals(null, req.getReceipt());
		assertEquals(RequestStatus.APPROVED, req.getStatus());
	}
	
	@Test
	public void testSetters() {
		LocalDateTime dt1 = LocalDateTime.now();
		ReimbursementRequest req1 = new ReimbursementRequest(1, 100, dt1, 1, null,
				"description", RequestStatus.APPROVED, 3, dt1);
		ReimbursementRequest req2 = req1;
		LocalDateTime dt2 = LocalDateTime.now();
		
		assertEquals(req2, req1);
		
		req1 = req1.setAmount(150);
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setDatePro(dt2);
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
		req1 = req1.setManagerId(10);
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setReceipt(null);
		assertNotEquals(req1, req2);
		req2 = req1;
		req1 = req1.setStatus(RequestStatus.DENIED);
		assertNotEquals(req1, req2);
		
		assertEquals(5, req1.getId());
		assertEquals(150.0, req1.getAmount(), 0.1);
		assertEquals(2, req1.getEmplId());
		assertEquals(10, req1.getManagerId());
		assertEquals(dt2, req1.getDatePro());
		assertEquals(dt2, req1.getDateReq());
		assertEquals("new description", req1.getDescription());
		assertEquals(null, req1.getReceipt());
		assertEquals(RequestStatus.DENIED, req1.getStatus());
		
		
	}

}
