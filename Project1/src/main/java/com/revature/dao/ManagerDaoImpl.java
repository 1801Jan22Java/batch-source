package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.beans.Reimb;
import com.revature.util.ConnectionUtil;
import com.revature.util.IncorrectCredentialsException;

public class ManagerDaoImpl implements ManagerDao {
	
	private static String filename = "connection.properties";

	@Override
	public Manager getManagerById(int mgrId) {
		PreparedStatement pstmt = null;
		Manager mgr = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM MANAGER WHERE MANAGER_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mgrId);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASS_WORD");
				
				mgr = new Manager(mgrId, firstname, lastname, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mgr;
	}
	
	@Override
	public Manager getManagerByUsername(String username) {
		PreparedStatement pstmt = null;
		Manager mgr = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM MANAGER WHERE USERNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int mgrId = rs.getInt("MANAGER_ID");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String password = rs.getString("PASS_WORD");
				
				mgr = new Manager(mgrId, firstname, lastname, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mgr;
	}

	@Override
	public Manager login(String username, String password) throws IncorrectCredentialsException {
		PreparedStatement pstmt = null;
		Manager mgr = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM MANAGER WHERE USERNAME=? AND PASS_WORD=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int mgrId = rs.getInt("MANAGER_ID");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				mgr = new Manager(mgrId, firstname, lastname, username, password);
			} else {
				throw new IncorrectCredentialsException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mgr;
	}

	@Override
	public List<Reimb> getAllReimbs() {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getAllReimbs();
	}

	@Override
	public List<Reimb> getPendingReimbs() {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getPendingReimbs();
	}

	@Override
	public List<Reimb> getResolvedReimbs() {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getResolvedReimbs();
	}

	@Override
	public void approve(Manager mgr, Reimb r) {
		ReimbDao rdi = new ReimbDaoImpl();
		rdi.approve(mgr, r);
	}

	@Override
	public void deny(Manager mgr, Reimb r) {
		ReimbDao rdi = new ReimbDaoImpl();
		rdi.deny(mgr, r);
	}

	@Override
	public List<Employee> getAllEmployees() {
		PreparedStatement pstmt = null;
		List<Employee> employees = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			employees = new ArrayList<Employee>();
			String sql = "SELECT * FROM EMPLOYEE";
			
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("EMPLOYEE_ID");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				String job = rs.getString("JOB_TITLE");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASS_WORD");
				
				employees.add(new Employee(empId, fname, lname, job, username, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public List<Reimb> getAllReqFromEmp(Employee emp) {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getAllReqFromEmp(emp);
	}

	@Override
	public List<Reimb> getAllPendingReqFromEmp(Employee emp) {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getAllPendingReqFromEmp(emp);
	}

	@Override
	public List<Reimb> getAllResolvedReqFromEmp(Employee emp) {
		ReimbDao rdi = new ReimbDaoImpl();
		return rdi.getAllResolvedReqFromEmp(emp);
	}

}
