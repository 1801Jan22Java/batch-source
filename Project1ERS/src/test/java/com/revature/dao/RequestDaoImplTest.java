package com.revature.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.beans.RequestStatus;
import com.revature.beans.RequestType;

public class RequestDaoImplTest {

	@Test
	public final void testAssertions() {
		RequestDaoImpl rd = new RequestDaoImpl();
		
		Employee thisManager = new Employee(98765, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		Request thisRequest = new Request(98765, "Travel", "Pending", thisManager, 100, "This is a request", LocalDate.now());
		
		// Returns false when employeeid not found
		assertFalse(rd.getRequests(thisManager));
		
		
		// Returns false when employeeid not found
		assertFalse(rd.addRequest(4000, 100, "This is a new request", thisManager));
		
		// Returns ArrayList object
		assertNotNull(rd.getRequestTypes());
		
		
		// Returns null when requestid not found
		assertNull(rd.getRequestAuthor(98765));
		
		
		// Returns ArrayList object
		assertNotNull(rd.getRequestStatuses());
	}
}
