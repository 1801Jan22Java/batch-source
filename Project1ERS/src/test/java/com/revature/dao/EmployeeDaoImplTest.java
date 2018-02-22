package com.revature.dao;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.beans.Employee;

public class EmployeeDaoImplTest {

	@Test
	public final void testAssertions() {
		
		Employee thisManager = new Employee(9876, "Boss", "Man", "boss@company.com", "The Boss", LocalDate.now());
		EmployeeDaoImpl emd = new EmployeeDaoImpl();
		// Returns null for incorrect email and password
		assertNull(emd.login("testing@email.com", "wrongpassword"));
		
		// Returns null for employee id not found
		assertNull(emd.getEmployee(9876));
		
		// Returns false for employee id not found
		assertFalse(emd.isManager(thisManager));
		
		// Returns false for employee id not found
		assertFalse(emd.getAllEmployees(thisManager));

		
		// Returns false for employee id not found
		assertFalse(emd.updateProfile("John", "Doe", "john@doe.com", "notapassword", "notajob", thisManager));
		
		// Returns true for unused email
		assertTrue(emd.isAvailable("unusedemail@email.com"));

	}
}
