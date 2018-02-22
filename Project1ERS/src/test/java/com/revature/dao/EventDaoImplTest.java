package com.revature.dao;

import static org.junit.Assert.assertFalse;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.beans.Request;

public class EventDaoImplTest {

	@Test
	public final void testAssertions() {
		Employee thisManager = new Employee(1, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		Request thisRequest = new Request(98765, "Travel", "Pending", thisManager, 100, "This is a request", LocalDate.now());
		EventDaoImpl evd = new EventDaoImpl();
		
		// Returns false for requestid not found
		assertFalse(evd.getEvents(thisRequest));
		
		// Returns false for requestid not found
		assertFalse(evd.addEvent(4000, "This is an event",thisRequest, thisManager));
	}
}
