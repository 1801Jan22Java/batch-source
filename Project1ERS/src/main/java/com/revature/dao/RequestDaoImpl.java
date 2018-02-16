package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Random;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao{

	@Override
	public boolean getRequests(Employee thisEmployee) {
		thisEmployee.getRequests().clear();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT r.request_id, ca.ref_value AS request_type, cb.ref_value AS current_status, r.amount, r.description, r.creation_date, " +
					"e.employee_id, e.firstname, e.lastname, e.email, e.job_title, e.creation_date AS emp_creation_date " + 
					"FROM request r " + 
					"INNER JOIN common_lookup ca ON ca.common_lookup_id = r.request_type_id " + 
					"INNER JOIN common_lookup cb ON cb.common_lookup_id = r.current_status_id " + 
					"LEFT JOIN employee e ON e.employee_id = r.current_manager_id " +
					"WHERE request_author_id = ? " +
					"ORDER BY r.creation_date DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, thisEmployee.getEmployeeId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int requestId = rs.getInt("request_id");
				String requestType = rs.getString("request_type");
				String currentStatus = rs.getString("current_status");
				float amount = rs.getFloat("amount");
				String description = rs.getString("description");
				LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
				// If the request has not been finalized by a manager set the manager to null
				Employee thisManager = null;
				if (rs.getInt("employee_id") > 0) {
					int employeeId = rs.getInt("employee_id");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String email = rs.getString("email");
					String jobTitle = rs.getString("job_title");
					LocalDate empCreationDate = rs.getDate("emp_creation_date").toLocalDate();
					thisManager = new Employee(employeeId, firstname, lastname, email, jobTitle, empCreationDate);
				}
				
				thisEmployee.getRequests().add(new Request(requestId, requestType, currentStatus, thisManager, amount, description, creationDate));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean addRequest(int requestTypeId, double amount, String description, Employee thisEmployee) {
		CallableStatement cs = null;
		boolean success = false;
		String currentStatus = "Pending";
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "{ call add_request(?, ?, ?, ?, ?, ?, ?, ?) }";
			cs = con.prepareCall(sql);
			cs.setInt(1, thisEmployee.getEmployeeId());
			cs.setInt(2, requestTypeId);
			cs.setDouble(3, amount);
			cs.setString(4, description);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.DATE);
			cs.registerOutParameter(8, Types.INTEGER);
			
			// Returns 1 if there is an OUT parameter, and 0 for no OUT parameter
			cs.executeUpdate();
			int response =  cs.getInt(8);
			if (response > 0) {
				success = true;
				String requestType = cs.getString(5);
				int requestId = cs.getInt(6);
				LocalDate creationDate = cs.getDate(7).toLocalDate();
				Request newRequest = new Request(requestId, requestType, currentStatus, null, amount, description, creationDate);
				thisEmployee.getRequests().add(newRequest);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return success;
	}

}
