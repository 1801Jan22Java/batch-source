package com.revature.test;
import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
public class EmployeeDaoImplTest {
	@Test
	public static void testEmployeeDaoImpl() {
		EmployeeDao ed = new EmployeeDaoImpl();
		List<Employee> employees = ed.getEmployees();
		assertNotNull(employees);
		
		assertNull(ed.getEmployeeById(0));
		assertNotNull(ed.getEmployeeById(1061));
		
		assertNotNull(ed.addEmployee("Jimmy", "Jma", "j@g.com", "p", 0, 0, new ArrayList<Request>()));
		assertTrue(ed.updateEmployee(ed.getEmployeeByUsernameAndPassword("j@g.com", "p").getId(), "paw@gmail.com", "Emp_Email"));
		assertTrue(ed.updateEmployee(ed.getEmployeeByUsernameAndPassword("j@g.com", "p").getId(), "pa", "Emp_Password"));
		assertTrue(ed.deleteEmployee(ed.getEmployeeByUsernameAndPassword("j@g.com", "p").getId()));
	}
}
