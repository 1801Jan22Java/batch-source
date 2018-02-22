package com.revature.beans;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class EventTest {

	@Test
	public final void testAssertions() {
		
		Employee thisManager = new Employee(1, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		Event thisEvent = new Event(1, thisManager, "Pending", "This is an update", LocalDate.now()); 
		
		// Returns 1 from thisEvent
		assertEquals(thisEvent.getEventId(), 1);
		
		thisEvent.setEventId(10);
		// Returns 10 from modified thisEvent
		assertEquals(thisEvent.getEventId(), 10);
		
		// Returns Employee object
		assertNotNull(thisEvent.getEventAuthor());
		
		// Returns "Pending"
		assertEquals(thisEvent.getRequestStatus(), "Pending");
		
		thisEvent.setRequestStatus("Approved");
		// Returns "Approved"
		assertEquals(thisEvent.getRequestStatus(), "Approved");
		
		// Returns "This is an update"
		assertEquals(thisEvent.getMessage(), "This is an update");
		
		thisEvent.setMessage("This is not an update");
		// Returns "This is not an update"
		assertEquals(thisEvent.getMessage(), "This is not an update");
				
		// Returns Date object
		assertNotNull(thisEvent.getCreationDate());
		
		
	}
}
