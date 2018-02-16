package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class EventDaoImpl implements EventDao{

	@Override
	public boolean getEvents(Request thisRequest) {
		thisRequest.getEvents().clear();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT ev.event_id, em.employee_id, em.firstname, em.lastname, em.email, em.job_title, em.creation_date AS emp_creation_date, c.common_lookup_id AS request_status, ev.message, ev.creation_date " + 
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

}
