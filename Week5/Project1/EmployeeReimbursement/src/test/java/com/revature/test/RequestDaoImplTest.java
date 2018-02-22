package com.revature.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

public class RequestDaoImplTest {
	@Test
	public static void testRequestDaoImpl() {
		RequestDao rd = new RequestDaoImpl();
		List<Request> requests = rd.getRequests();
		assertNotNull(requests);
		
		assertNull(rd.getRequestById(0));
		assertNotNull(rd.getRequestById(1211));
		
		assertNotNull(rd.addRequest(1061, LocalDate.now(), 5, "Pending", "Somrething", "hey", 1061, "", null));
		assertTrue(rd.updateRequest(rd.getRequestById(1211).getId(), "Approved", "Status_Id"));
		assertTrue(rd.updateRequest(rd.getRequestById(1211).getId(), "test", "Manager_Notes"));
		assertTrue(rd.updateRequest(rd.getRequestById(1211).getId(), "test", "Manager_Id"));
		assertTrue(rd.deleteRequest(rd.getRequestById(1211).getId()));
	}
}
