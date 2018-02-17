package com.revature.dao;

import java.util.List;

import org.junit.Test;

import com.revature.beans.Employee;

import junit.framework.TestCase;

public class EmployeeDaoTest extends TestCase {
	
	@Test
	public void testGetListEmployees() {
		EmployeeDaoSQL eds = new EmployeeDaoSQL();
		List<Employee> listEmployee = eds.getEmployees();
		assertTrue(listEmployee.size() > 0);
		for (Employee em : listEmployee) {
			assertNotNull(em);
			Employee employeeById = eds.getEmployeeByID(em.getEmployeeId());
			assertEquals(em.getEmployeeId(),employeeById.getEmployeeId());
			assertEquals(em.getUsername(),employeeById.getUsername());
			assertEquals(em.getPassword(),employeeById.getPassword());
			assertEquals(em.getEmployeeInformationId(),employeeById.getEmployeeInformationId());
			System.out.println(em.toString());
		}
		
	}
	
	@Test
	public void testGetEmployeeById() {
		EmployeeDaoSQL eds = new EmployeeDaoSQL();
		Employee employeeById = eds.getEmployeeByID(1000);
		assertNotNull(employeeById);
		assertEquals(employeeById.getEmployeeId(),1000);
		assertEquals(employeeById.getUsername(), "f");
		assertEquals(employeeById.getPassword(), "p");
		assertEquals(employeeById.getEmployeeInformationId(),1000);
	}
	
	@Test
	public void testGetEmployeeByCredentials() {
		EmployeeDaoSQL eds = new EmployeeDaoSQL();
		Employee employeeByCredentials = eds.getEmployeeByCredentials("f","p");
		assertNotNull(employeeByCredentials);
		assertEquals(employeeByCredentials.getEmployeeId(),1000);
		assertEquals(employeeByCredentials.getUsername(), "f");
		assertEquals(employeeByCredentials.getPassword(), "p");
		assertEquals(employeeByCredentials.getEmployeeInformationId(),1000);
		
	}
	
	@Test
	public void testAddEmployee() {
		EmployeeDaoSQL eds = new EmployeeDaoSQL();
		int newEmployeeId = eds.addEmployee("new_user","new_password","email@email","fname","lname","address");
		Employee newEmployee = eds.getEmployeeByID(newEmployeeId);
		assertNotNull(newEmployee);
		assertEquals(newEmployee.getEmployeeId(),newEmployeeId);
		assertEquals(newEmployee.getUsername(), "new_user");
		assertEquals(newEmployee.getPassword(), "new_password");
		assertEquals(newEmployee.getEmployeeInformationId(),1001);
	}
	
}
