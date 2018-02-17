package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.EmployeeInformation;
import com.revature.util.ConnectionUtil;

public class EmployeeInformationDaoSQL implements EmployeeInformationDao{

	// returns a list of every employeeinformation in the database
	// if there is no employeeinformation in the DB then the list is empty
	public List<EmployeeInformation> getEmployeeInformation() {
		
		// initializes a list to return, if the list is empty it is not for the
		// Dao object to decide
		List<EmployeeInformation> listEmployeeInformation = new ArrayList<EmployeeInformation>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			// result is a placeholder variable for creating employees to insert into the list
			EmployeeInformation result;
			String sql = "SELECT * FROM EmployeeInfo";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int employeeInformationId = rs.getInt("EMPLOYEE_INFO_ID");
				String email = rs.getString("EMAIL");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String address = rs.getString("ADDRESS");
				result = new EmployeeInformation(employeeInformationId,email,firstname,lastname,address);
				listEmployeeInformation.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listEmployeeInformation;
	}

	// get an employeeInformation from the database using the Id 
	// to be used predominately by the application no the user
	public EmployeeInformation getEmployeeInformationByID(int requestedEmployeeInformationId) {
		// if employeeInformationResult is null then you could not find the requested Id
		// not for this function to decide what to do with that information
		EmployeeInformation employeeInformationResult = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			System.out.println(requestedEmployeeInformationId);
			String sql = "SELECT * FROM EMPLOYEEINFO WHERE EMPLOYEE_INFO_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println(con.getMetaData().getDatabaseProductName());
			ps.setInt(1, requestedEmployeeInformationId);
			ResultSet rs = ps.executeQuery();
			System.out.println();
			while(rs.next()) {
				int employeeInformationId = rs.getInt("EMPLOYEE_INFO_ID");
				String email = rs.getString("EMAIL");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String address = rs.getString("ADDRESS");
				employeeInformationResult = new EmployeeInformation(employeeInformationId,email,firstname,lastname,address);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeInformationResult;
	}

	// updates the employeeinformation based on the employeeinformationid
	// returns false if nothing
	public void updateInformation(int employeeInformationId,String email,String fname,String lname,String address) {
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			con.setAutoCommit(false);
			String sql = "{call UPDATE_EMPLOYEE_INFORMATION(?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, employeeInformationId);
			cs.setString(2, email);
			cs.setString(3, fname);
			cs.setString(4, lname);
			cs.setString(5, address);
			
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
