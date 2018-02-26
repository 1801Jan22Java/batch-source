package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	private static String filename = "connection.properties";

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		DepartmentDaoImpl ddi = new DepartmentDaoImpl();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM EMPLOYEES";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("EMP_FIRSTNAME");
				String lastname = rs.getString("EMP_LASTNAME");
				int d_id = rs.getInt("DEPARTMENT_ID");
				Department department = ddi.getDepartmentById(d_id);
				int salary = rs.getInt("SALARY");
				String email = rs.getString("EMP_EMAIL");
				employees.add(new Employee(id,firstname,lastname, department,salary, email));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		PreparedStatement pstmt = null;
		DepartmentDaoImpl ddi = new DepartmentDaoImpl();
		Employee employee = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String firstname = rs.getString("EMP_FIRSTNAME");
				String lastname = rs.getString("EMP_LASTNAME");
				int d_id = rs.getInt("DEPARTMENT_ID");
				Department department = ddi.getDepartmentById(d_id);
				int salary = rs.getInt("SALARY");
				String email = rs.getString("EMP_EMAIL");
				employee = new Employee(id,firstname,lastname, department,salary, email);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return employee;
	}

	@Override
	public void createEmployee(String firstname, String lastname, int department_id, int salary, String email)
	{
		PreparedStatement stmt = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "INSERT INTO EMPLOYEES(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			if(firstname != null)
				stmt.setString(1, firstname);
			if(lastname != null)
				stmt.setString(2, lastname);
			if(department_id > 0)
				stmt.setInt(3, department_id);
			if(salary > 0)
				stmt.setInt(4, salary);
			if(email != null)
				stmt.setInt(5, salary);
			ResultSet rs = stmt.executeQuery();
			conn.close();
			//manual transaction control
			//set conn.setAutoCommit(false);
			//try (con.commit());
			//in catch, con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBankAccount(Employee employee) {
		CallableStatement cs = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=(?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1,employee.getId());
			cs.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void giveRaise(int departmentId) {
		CallableStatement cs = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "{?,?= call SP_GIVE_RAISE{?}";
			cs = conn.prepareCall(sql);
			cs.setInt(3,departmentId);
			cs.registerOutParameter(1,java.sql.Types.INTEGER);
			cs.registerOutParameter(2,java.sql.Types.BOOLEAN);
			System.out.println(cs.getInt(1));
			System.out.println(cs.getInt(2));
			cs.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printDepartmentSalary()
	{
		PreparedStatement stmt = null;
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENT";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			sql = "SELECT AVG(SALARY) FROM EMPLOYEES;";
			stmt = conn.prepareStatement(sql);
			ResultSet rs2 = stmt.executeQuery();
			
			ArrayList<String> names = new ArrayList<String>();
			
			while(rs.next())
				names.add(rs.getString("DEPARTMENT_NAME"));
			int[] averages = new int[names.size()];
			int i = 0;
			System.out.println("DEPARTMENT NAME | AVERAGE SALARY");
			while(rs2.next())
			{
				System.out.println(names.get(i) + "    |     " + averages[i]);
				i++;
			}
			conn.close();
			//manual transaction control
			//set conn.setAutoCommit(false);
			//try (con.commit());
			//in catch, con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
