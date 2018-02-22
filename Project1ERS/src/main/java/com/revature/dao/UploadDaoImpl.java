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

public class UploadDaoImpl implements UploadDao{
	// FILENAME_LENGTH must match database field limit
	// How do I get the field length from a SQL query?
	// Make new Dao to check display name limit to validate file user wants to upload
	
	// Make VARCHAR2 as big as possible, define smaller restriction in servlet parameter
	private static final int FILENAME_LENGTH = 10;

	@Override
	public boolean getUploads(Request thisRequest) {
		thisRequest.getUploads().clear();
		PreparedStatement pstmt = null;
		boolean success = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT u.upload_id, u.display_name, u.creation_date, u.filename, " + 
					"e.employee_id, e.firstname, e.lastname, e.email, e.job_title, e.creation_date AS emp_creation_date " +
					"FROM upload u  " + 
					"INNER JOIN employee e ON e.employee_id = u.upload_author_id " + 
					"WHERE u.request_id = ? " +
					"ORDER BY u.creation_date DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, thisRequest.getRequestId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				success = true;
				int employeeId = rs.getInt("employee_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String jobTitle = rs.getString("job_title");
				LocalDate empCreationDate = rs.getDate("emp_creation_date").toLocalDate();
				Employee uploadAuthor = new Employee(employeeId, firstname, lastname, email, jobTitle, empCreationDate );
					
				int uploadId = rs.getInt("upload_id");
				String displayName = rs.getString("display_name");
				String filename = rs.getString("filename");
				LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
				thisRequest.getUploads().add(new Upload(uploadId, displayName, filename, creationDate, uploadAuthor));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return success;
	}
	
	@Override
	public boolean isDuplicate(String randomFileName) {
		PreparedStatement pstmt = null;
		boolean isDuplicate = true;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT upload_id FROM upload WHERE filename = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,randomFileName);
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then the username is taken, so set isUnique to false
			// IF rs.next() returns false, then the username is available, so set isUnique to true
			isDuplicate = rs.next();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return isDuplicate;
	}

	@Override
	public boolean addUpload(String displayName, Request thisRequest, Employee thisEmployee) {
		CallableStatement cs = null;
		boolean success = false;
		String splitDisplayName[]= displayName.split("\\.");
		String extension = "." + splitDisplayName[splitDisplayName.length - 1];
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "{ call add_upload(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
			System.out.println("{ call add_upload("+displayName+", "+extension+", "+thisRequest.getRequestId()+", "+thisEmployee.getEmployeeId()+", ?, ?, ?, ?, ?) }");
			cs = con.prepareCall(sql);
			cs.setString(1, displayName);
			cs.setString(2, extension);
			cs.setInt(3, thisRequest.getRequestId());
			cs.setInt(4, thisEmployee.getEmployeeId());
			cs.setInt(5, FILENAME_LENGTH);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.DATE);
			cs.registerOutParameter(9, Types.INTEGER);
			
			// Returns 1 if there is an OUT parameter, and 0 for no OUT parameter
			cs.executeUpdate();
			int response =  cs.getInt(9);
			if (response > 0) {
				success = true;
				String newFilename = cs.getString(6);
				int uploadId = cs.getInt(7);
				LocalDate creationDate = cs.getDate(8).toLocalDate();
				
				int authEmployeeId = thisEmployee.getEmployeeId();
				String authFirstname = thisEmployee.getFirstname();
				String authLastname = thisEmployee.getLastname();
				String authEmail = thisEmployee.getEmail();
				String authJobTitle = thisEmployee.getJobTitle();
				LocalDate authCreationDate = thisEmployee.getCreationDate();
				
				Employee uploadAuthor = new Employee(authEmployeeId, authFirstname, authLastname, authEmail, authJobTitle, authCreationDate);
				thisRequest.getUploads().add(new Upload(uploadId, displayName, newFilename, creationDate, uploadAuthor));
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
