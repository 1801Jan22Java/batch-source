package com.revature.beans;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

public class RequestTest {
	
	@Test
	public final void testAssertions() {
		Employee thisManager = new Employee(1, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		Request thisRequest = new Request(1, "Travel", "Pending", thisManager, 100, "This is a request", LocalDate.now());
		
		// Returns 1 from thisRequest
		assertEquals(thisRequest.getRequestId(), 1);
				
		thisRequest.setRequestId(10);
		// Returns 1 from thisRequest
		assertEquals(thisRequest.getRequestId(), 10);
		
		// Return "Travel" from thisRequest
		assertEquals(thisRequest.getRequestType(), "Travel");
		
		thisRequest.setRequestType("Medical");
		// Return "Medical" from thisRequest
		assertEquals(thisRequest.getRequestType(), "Medical");
		
		// Returns "Pending"
		assertEquals(thisRequest.getCurrentStatus(), "Pending");
		
		thisRequest.setCurrentStatus("Approved");
		// Returns "Approved"
		assertEquals(thisRequest.getCurrentStatus(), "Approved");
				
		// Returns "Pending"
		assertEquals(thisRequest.getDescription(), "This is a request");
		
		thisRequest.setDescription("This is not a request");
		// Returns "Approved"
		assertEquals(thisRequest.getDescription(), "This is not a request");
		
		// Returns Date object
		assertNotNull(thisRequest.getCreationDate());
				
		// Returns ArrayList object
		assertNotNull(thisRequest.getEvents());
		
		// Returns ArrayList object
		assertNotNull(thisRequest.getUploads());
		
		// Returns ArrayList object
		assertNotNull(thisRequest.getCurrentManager());
		
		
	}
}
