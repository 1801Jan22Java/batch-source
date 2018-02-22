package com.revature.beans;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
public class ProcessedRequestTest {
	@Test
	public void testNoArgConstructor() {
		ProcessedRequest pr = new ProcessedRequest();
		
		assertEquals(pr.getId(), 0);
		assertEquals(pr.getManagerId(), 0);
		assertEquals(pr.getReqId(), 0);
		assertEquals(pr.getStatus(), null);
		assertEquals(pr.getDatePro(), null);
	}
	
	@Test
	public void testNoIdConstructor() {
		LocalDate date = LocalDate.now();
		ProcessedRequest pr = new ProcessedRequest(201, RequestStatus.APPROVED, 3, date);
		
		assertEquals(pr.getId(), 0);
		assertEquals(pr.getManagerId(), 3);
		assertEquals(pr.getReqId(), 201);
		assertEquals(pr.getStatus(), RequestStatus.APPROVED);
		assertTrue(pr.getDatePro().equals(date));
	}
	
	@Test
	public void testNoFullConstructor() {
		LocalDate date = LocalDate.now();
		ProcessedRequest pr = new ProcessedRequest(20, 201, RequestStatus.APPROVED, 3, date);
		
		assertEquals(pr.getId(), 20);
		assertEquals(pr.getManagerId(), 3);
		assertEquals(pr.getReqId(), 201);
		assertEquals(pr.getStatus(), RequestStatus.APPROVED);
		assertTrue(pr.getDatePro().equals(date));
	}
	
	@Test
	public void testGettersAndSetters() {
		LocalDate date = LocalDate.now();
		ProcessedRequest pr1 = new ProcessedRequest(20, 201, RequestStatus.APPROVED, 3, date);
		ProcessedRequest pr2 = pr1;
		
		
		pr1 = pr1.setId(12);
		assertNotEquals(pr1, pr2);
		assertEquals(pr1.getId(), 12);
		pr2 = pr1;
		
		pr1 = pr1.setManagerId(40);
		assertNotEquals(pr1, pr2);
		assertEquals(pr1.getManagerId(), 40);
		pr2 = pr1;
		
		pr1 = pr1.setReqId(700);
		assertNotEquals(pr1, pr2);
		assertEquals(pr1.getReqId(), 700);
		pr2 = pr1;
		
		pr1 = pr1.setStatus(RequestStatus.DENIED);
		assertNotEquals(pr1, pr2);
		assertEquals(pr1.getStatus(), RequestStatus.DENIED);
		pr2 = pr1;
		
		LocalDate d = LocalDate.now();
		pr1 = pr1.setDatePro(d);
		assertNotEquals(pr1, pr2);
		assertTrue(pr1.getDatePro().equals(d));
	}
	
	
}
