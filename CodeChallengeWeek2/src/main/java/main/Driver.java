package main;

import DOA.DepartmentDAOImpl;
import DOA.EmployeeDAOImpl;

public class Driver {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		DepartmentDAOImpl departDAO = new DepartmentDAOImpl();
		System.out.println(departDAO.getDepartments().toString());
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
		System.out.println(employeeDAO.getEmployees().toString());
	}

}
