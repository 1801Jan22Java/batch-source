package com.revature.beans;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testNoArgsConstructor() {
		Employee empl = new Employee();

		assertEquals(0, empl.getId());
		assertEquals(null, empl.getFirstName());
		assertEquals(null, empl.getLastName());
		assertEquals(null, empl.getUserName());
		assertEquals(null, empl.getPassword());
		assertEquals(null, empl.getRequests());
		assertEquals(null, empl.getTitle());
	}

	@Test
	public void testConstructorNoId() {
		Employee empl = new Employee("John", "Smith", "jsmith", "password",
				EmployeeTitle.EMPLOYEE, "email@email.com", null);

		assertEquals(0, empl.getId());
		assertEquals("John", empl.getFirstName());
		assertEquals("Smith", empl.getLastName());
		assertEquals("jsmith", empl.getUserName());
		assertEquals("password", empl.getPassword());
		assertEquals(null, empl.getRequests());
		assertEquals(EmployeeTitle.EMPLOYEE, empl.getTitle());
	}
	
	@Test
	public void testFullConstructor() {
		Employee empl = new Employee(1, "John", "Smith", "jsmith", "password",
				EmployeeTitle.EMPLOYEE, "email@email.com", null);

		assertEquals(1, empl.getId());
		assertEquals("John", empl.getFirstName());
		assertEquals("Smith", empl.getLastName());
		assertEquals("jsmith", empl.getUserName());
		assertEquals("password", empl.getPassword());
		assertEquals(null, empl.getRequests());
		assertEquals(EmployeeTitle.EMPLOYEE, empl.getTitle());
	}
	
	@Test
	public void testGettersAndSetters() {
		Employee empl1 = new Employee(1, "John", "Smith", "jsmith", "password",
				EmployeeTitle.EMPLOYEE, "email@email.com", null);
		Employee empl2 = empl1;
		
		assertEquals(empl2, empl1);
		empl2 = empl1.setId(2);
		assertNotEquals(empl2, empl1);
		empl2 = empl2.setFirstName("Jane");
		empl2 = empl2.setLastName("Doe");
		empl2 = empl2.setUserName("jdoe");
		empl2 = empl2.setPassword("12345");
		empl2.setRequests(new ArrayList<ReimbursementRequest>());
		empl2 = empl2.setTitle(EmployeeTitle.MANAGER);
		
		assertEquals(2, empl2.getId());
		assertEquals("Jane", empl2.getFirstName());
		assertEquals("Doe", empl2.getLastName());
		assertEquals("jdoe", empl2.getUserName());
		assertEquals("12345", empl2.getPassword());
		assertEquals(null, empl2.getRequests());
		assertEquals(EmployeeTitle.MANAGER, empl2.getTitle());
		
		ArrayList<ReimbursementRequest> reqs = new ArrayList<>();
		empl2 = empl2.setRequests(reqs);
		assertEquals(reqs, empl2.getRequests());
	}

}
