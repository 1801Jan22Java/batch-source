package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Upload;
import com.revature.util.ConnectionUtil;

public class UploadDaoImpl implements UploadDao
{
	public List<Upload> getUploads() 
	{
		List<Upload> uploads = new ArrayList<Upload>();
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM Upload";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
			{
				int id = rs.getInt("Upload_Id");
				String filename = rs.getString("Filename");
				int requestId = rs.getInt("Request_Id");
				uploads.add(new Upload(id, filename, requestId));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return uploads;
	}

	public Upload getUploadById(int id) 
	{
		Upload upload = null;
		
		PreparedStatement pstmt = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM Upload WHERE Upload_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String filename = rs.getString("Filename");
				int requestId = rs.getInt("Request_Id");
				upload = new Upload(id, filename, requestId);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return upload;
	}
	
	public Upload getUploadByRequestId(int id) 
	{
		Upload upload = null;
		
		PreparedStatement pstmt = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM Upload WHERE Request_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int uploadId = rs.getInt("Upload_Id");
				String filename = rs.getString("Filename");
				
				upload = new Upload(uploadId, filename, id);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return upload;
	}

	public Upload addUpload(String filename, int requestId)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		Upload upload = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "INSERT INTO Upload (Filename, Request_Id) VALUES(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, filename);
			pstmt.setInt(2, requestId);
			pstmt.executeUpdate();
			con.close();
			upload = new Upload(filename, requestId);
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
		return upload;
	}
	
	public boolean updateUpload(int id, String value, String columnName)
	{
		PreparedStatement pstmt = null;
		int uploadsUpdated = 0;
		try{
			String sql = "";
			Connection con = ConnectionUtil.getConnectionFromFile();
			sql = "UPDATE Upload SET " + columnName + " = ? WHERE Upload_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setInt(2, id);
			// Save number returned from updated statement
			uploadsUpdated = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(uploadsUpdated > 0)
			return true;
		else
			return false;
	}

	public boolean deleteUpload(int id) 
	{
		PreparedStatement pstmt = null;
		int uploadsDeleted = 0;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "DELETE FROM Upload WHERE Upload_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			// Save number returned from delete statement
			uploadsDeleted = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(uploadsDeleted > 0)
			return true;
		else
			return false;
	}
}
