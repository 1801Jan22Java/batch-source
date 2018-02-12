package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class UploadDaoImpl implements UploadDao{
	private static String filename = "connection.properties";

	@Override
	public boolean getUploads(Request thisRequest) {
		thisRequest.getUploads().clear();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT u.creation_date, u.filename, " + 
					"e.employee_id, e.firstname, e.lastname, e.email, e.job_title, e.creation_date AS emp_creation_date " +
					"FROM upload u  " + 
					"INNER JOIN employee e ON e.employee_id = u.upload_author_id " + 
					"WHERE u.request_id = ? " +
					"ORDER BY u.creation_date DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, thisRequest.getRequestId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				
				int employeeId = rs.getInt("employee_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String jobTitle = rs.getString("job_title");
				LocalDate empCreationDate = rs.getDate("emp_creation_date").toLocalDate();
				Employee uploadAuthor = new Employee(employeeId, firstname, lastname, email, jobTitle, empCreationDate );
					
				String filename = rs.getString("filename");
				LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
				thisRequest.getUploads().add(new Upload(filename, creationDate, uploadAuthor));
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
