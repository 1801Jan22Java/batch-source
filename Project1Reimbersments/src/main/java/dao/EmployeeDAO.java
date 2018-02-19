package dao;

import java.util.ArrayList;

import beans.Employee;

public interface EmployeeDAO 
{
	public ArrayList<Employee> getEmployees();
	public Employee getEmployee( int id);
	public boolean addEmployee(Employee e);
	public boolean removeEmployee(int id);
	ArrayList<Employee> getEmployeesByManager(int managerId);
}
