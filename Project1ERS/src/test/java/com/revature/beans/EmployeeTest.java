package com.revature.beans;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class EmployeeTest {
	
	@Test
	public final void testAssertions() {
		Employee thisManager = new Employee(1, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		Employee thisEmployee = new Employee(2, "Employee", "Person", "employee@company.com", "The Employee", LocalDate.now(), null);
		
		// Returns 1 from thisManager
		assertEquals(thisManager.getEmployeeId(), 1);
		
		thisManager.setEmployeeId(10);
		// Returns 10 from modified thisManager
		assertEquals(thisManager.getEmployeeId(), 10);
		
		// Returns "Boss" from thisManager
		assertEquals(thisManager.getFirstname(), "Boss");
		
		thisManager.setFirstname("John");
		// Returns "John" from modified thisManager
		assertEquals(thisManager.getFirstname(), "John");
		
		// Returns "Man" from thisManager
		assertEquals(thisManager.getLastname(), "Man");
		
		thisManager.setLastname("Doe");
		// Returns "Doe" from modified thisManager
		assertEquals(thisManager.getLastname(), "Doe");
		
		// Returns "boss@company.com" from thisManager
		assertEquals(thisManager.getEmail(), "boss@company.com");
		
		thisManager.setEmail("john@company.com");
		// Returns "john@company.com" from modified thisManager
		assertEquals(thisManager.getEmail(), "john@company.com");
		
		// Returns "boss@company.com" from thisManager
		assertEquals(thisManager.getJobTitle(), "The Boss");
		
		thisManager.setJobTitle("Manager");
		// Returns "Manager" from modified thisManager
		assertEquals(thisManager.getJobTitle(), "Manager");
		
		// Returns null from thisEmployee object
		assertNull(thisEmployee.getReportsTo());
		
		thisEmployee.setReportsTo(thisManager);
		// Returns Employee object
		assertNotNull(thisEmployee.getReportsTo());
	}

}
