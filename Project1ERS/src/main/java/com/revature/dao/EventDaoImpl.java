package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class EventDaoImpl implements EventDao{

	@Override
	public boolean getEvents(Request thisRequest) {
		thisRequest.getEvents().clear();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT ev.event_id, em.employee_id, em.firstname, em.lastname, em.email, em.job_title, em.creation_date AS emp_creation_date, c.ref_value AS request_status, ev.message, ev.creation_date " + 
					"FROM event ev " + 
					"INNER JOIN employee em ON em.employee_id = ev.event_author_id " + 
					"INNER JOIN common_lookup c ON c.common_lookup_id = ev.request_status_id " + 
					"WHERE request_id = ? " +
					"ORDER BY ev.creation_date DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, thisRequest.getRequestId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int eventId = rs.getInt("event_id");
				
				int employeeId = rs.getInt("employee_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String jobTitle = rs.getString("job_title");
				LocalDate empCreationDate = rs.getDate("emp_creation_date").toLocalDate();
				Employee eventAuthor = new Employee(employeeId, firstname, lastname, email, jobTitle, empCreationDate );
					
				String requestStatus = rs.getString("request_status");
				String message = rs.getString("message");
				LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
				thisRequest.getEvents().add(new Event(eventId, eventAuthor, requestStatus, message, creationDate));
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
	public boolean addEvent(int requestStatusId, String message, Request thisRequest, Employee eventAuthor) {
		CallableStatement cs = null;
		boolean success = false;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "{ call add_event(?, ?, ?, ?, ?, ?, ?, ?) }";
			cs = con.prepareCall(sql);
			cs.setInt(1, requestStatusId);
			cs.setString(2, message);
			cs.setInt(3, thisRequest.getRequestId());
			cs.setInt(4, eventAuthor.getEmployeeId());
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.DATE);
			cs.registerOutParameter(8, Types.INTEGER);
			
			// Returns 1 if there is an OUT parameter, and 0 for no OUT parameter
			cs.executeUpdate();
			int response =  cs.getInt(8);
			System.out.println("response = " + response);
			if (response > 0) {
				success = true;
				String requestStatus = cs.getString(5);
				System.out.println("requestStatus = " + requestStatus);
				int eventId = cs.getInt(6);
				LocalDate creationDate = cs.getDate(7).toLocalDate();
				Event newEvent = new Event(eventId, eventAuthor, requestStatus, message, creationDate);
				thisRequest.getEvents().add(newEvent);
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
