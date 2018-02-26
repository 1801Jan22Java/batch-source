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
	public void testRequestDaoImpl() {
		RequestDao rd = new RequestDaoImpl();
		List<Request> requests = rd.getRequests();
		assertNotNull(requests);
		
		assertNull(rd.getRequestById(0));
	}
}
