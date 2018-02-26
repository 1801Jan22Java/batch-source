package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Request;
import com.revature.beans.Upload;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao
{
	public List<Request> getRequests() 
	{
		List<Request> requests = new ArrayList<Request>();
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM Request INNER JOIN Common_Lookup ON Common_Lookup.Common_Lookup_Id = Request.Status_Id";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
			{
				int id = rs.getInt("Request_Id");
				int employeeId = rs.getInt("Employee_Id");
				String firstname = null;
				String lastname = null;
				PreparedStatement pstmt = null;
				sql = "SELECT Emp_FirstName, Emp_LastName FROM Employee WHERE Employee_Id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, employeeId);
				ResultSet rs2 = pstmt.executeQuery();
				while(rs2.next())
				{
					firstname = rs2.getString("Emp_FirstName");
					lastname = rs2.getString("Emp_LastName");
				}
				LocalDate dateCreated = rs.getDate("Created").toLocalDate();
				double amount = rs.getDouble("Amount");
				String status = rs.getString("Keyword");
				String purpose = rs.getString("Purpose");
				String employeeNotes = rs.getString("Employee_Notes");
				int managerId = rs.getInt("Manager_Id");
				String managerNotes = rs.getString("Manager_Notes");
				UploadDaoImpl udl = new UploadDaoImpl();
				for(Upload u : udl.getUploads())
					if(u.getRequestId() == id)
						requests.add(new Request(id, employeeId, firstname+" "+lastname, dateCreated, amount, status, purpose, employeeNotes, managerId, managerNotes, u));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return requests;

	}

	public Request getRequestById(int id) 
	{
		Request request = null;

		PreparedStatement pstmt = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM Request WHERE Request_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int employeeId = rs.getInt("Employee_Id");
				String firstname = null;
				String lastname = null;
				sql = "SELECT Emp_FirstName, Emp_LastName FROM Employee WHERE Employee_Id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, employeeId);
				ResultSet rs2 = pstmt.executeQuery(sql);
				while(rs2.next())
				{
					firstname = rs2.getString("Emp_FirstName");
					lastname = rs2.getString("Emp_LastName");
				}
				LocalDate dateCreated = rs.getDate("Created").toLocalDate();
				double amount = rs.getDouble("Amount");
				String status = null;
				sql = "SELECT * FROM Common_Lookup WHERE Common_Lookup_Id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(rs.getString("Status_Id")));
				ResultSet rs3 = pstmt.executeQuery(sql);
				while(rs3.next())
					status = rs3.getString("Keyword");
				String purpose = rs.getString("Purpose");
				String employeeNotes = rs.getString("Employee_Notes");
				int managerId = rs.getInt("Manager_Id");
				String managerNotes = rs.getString("Manager_Notes");
				UploadDao ud = new UploadDaoImpl();
				for(Upload u : ud.getUploads())
					if(u.getRequestId() == id)
						request = new Request(id, employeeId, firstname+" "+lastname, dateCreated, amount, status, purpose, employeeNotes, managerId, managerNotes, u);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return request;

	}

	public Request addRequest(int employeeId, LocalDate dateOfCreation, double amount, String status, String purpose, String employeeNotes, int managerId, String managerNotes, Upload upload)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		Request request = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT Common_Lookup_Id FROM Common_Lookup WHERE Keyword = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, status);
			int statusId = 0;
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				statusId = rs.getInt("Common_Lookup_Id");
			sql = "INSERT INTO Request (Employee_Id, Created, Amount, Status_Id, Purpose, Employee_Notes, Manager_Id, Manager_Notes) VALUES(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.setDate(2, Date.valueOf(dateOfCreation));
			pstmt.setDouble(3, amount);
			pstmt.setInt(4, statusId);
			pstmt.setString(5, purpose);
			pstmt.setString(6, employeeNotes);
			if(managerId == 0)
			{
				pstmt.setNull(7, java.sql.Types.INTEGER);
				pstmt.setString(8, "");
			}
			else
			{
				pstmt.setInt(7, managerId);
				pstmt.setString(8, managerNotes);
			}
			pstmt.executeUpdate();

			sql = "SELECT * FROM Request WHERE Employee_Id = ? AND Created = ? AND Purpose = ? AND Amount = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.setDate(2, Date.valueOf(dateOfCreation));
			pstmt.setString(3, purpose);
			pstmt.setDouble(4, amount);
			rs = pstmt.executeQuery();
			int requestId = 0;
			while(rs.next())
				requestId = rs.getInt("Request_Id");
			if(requestId != 0)
			{
				UploadDao ud = new UploadDaoImpl();
				ud.addUpload(upload.getFilename(), requestId);
				Upload u = ud.getUploadByRequestId(requestId);
				System.out.println("THIS IS YOUR UPLOAD: "+u);
				RequestDao rd = new RequestDaoImpl();
				request = rd.getRequestById(requestId);
				System.out.println("THIS IS YOUR REQUEST: "+request);
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			} 
			catch (Exception e1)
			{
				e.printStackTrace();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if (con != null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return request;
	}

	public boolean updateRequest(int id, String value, String columnName)
	{
		PreparedStatement pstmt = null;
		int requestsUpdated = 0;
		try{
			String sql = "";
			Connection con = ConnectionUtil.getConnectionFromFile();
			sql = "UPDATE Request SET " + columnName + " = ? WHERE Request_Id = ?";
			pstmt = con.prepareStatement(sql);
			//value.matches("\\d+(\\.\\d{1,2})?") regex pattern
			if(value.matches("^\\d+(\\.\\d{2})?$") && columnName.equals("Amount"))
			{
				if(!value.contains("."))
					value += ".00";
				pstmt.setDouble(1, Double.parseDouble(value));
			}
			else if(value.matches("^[0-9]*$") && (columnName.equals("Manager_Id") || columnName.equals("Status_Id"))) {
				pstmt.setInt(1, Integer.parseInt(value));
			}
			else {
				pstmt.setString(1, value);
			}
			pstmt.setInt(2, id);
			// Save number returned from updated statement
			requestsUpdated = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(requestsUpdated > 0)
			return true;
		else
			return false;

	}

	public boolean deleteRequest(int id) {
		PreparedStatement pstmt = null;
		int employeesDeleted = 0;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "DELETE FROM Request WHERE Request_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			// Save number returned from delete statement
			employeesDeleted = pstmt.executeUpdate();
			con.close();


		} catch (SQLException e) {
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(employeesDeleted > 0)
			return true;
		else
			return false;
	}
}
