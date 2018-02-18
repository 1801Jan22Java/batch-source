package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimb;
import com.revature.util.ConnectionUtil;
import com.revature.util.IncorrectCredentialsException;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static String filename = "connection.properties";

	@Override
	public Employee getEmployeeById(int empId) {
		PreparedStatement pstmt = null;
		Employee emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String job = rs.getString("JOB_TITLE");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASS_WORD");
				
				emp = new Employee(empId, firstname, lastname, job, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		PreparedStatement pstmt = null;
		Employee emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int empId = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String job = rs.getString("JOB_TITLE");
				String password = rs.getString("PASS_WORD");
				
				emp = new Employee(empId, firstname, lastname, job, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee login(String username, String password) throws IncorrectCredentialsException {
		PreparedStatement pstmt = null;
		Employee emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME=? AND PASS_WORD=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int empId = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String job = rs.getString("JOB_TITLE");
				emp = new Employee(empId, firstname, lastname, job, username, password);
			} else {
				throw new IncorrectCredentialsException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public List<Reimb> getAllReimbs(Employee emp) {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getAllReqFromEmp(emp);
	}

	@Override
	public List<Reimb> getPendingReimbs(Employee emp) {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getAllPendingReqFromEmp(emp);
	}

	@Override
	public List<Reimb> getResolvedReimbs(Employee emp) {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getAllResolvedReqFromEmp(emp);
	}

	@Override
	public void makeRequest(Reimb r) {
		ReimbDao rdi = new ReimbDaoImpl();
		rdi.createReimb(r);
	}

	@Override
	public void updateJobPass(Employee emp) {
		CallableStatement cstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL UPDATE_EMP(?, ?, ?)}";
			cstmt = con.prepareCall(sql);
			
			cstmt.setInt(1, emp.getEmpId());
			cstmt.setString(2, emp.getJob());
			cstmt.setString(3, emp.getPassword());
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
