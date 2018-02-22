package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.beans.Files;
import com.revature.util.ConnectionUtil;

public class FilesDaoImpl implements FilesDao {
	
	private static String filename = "connection.properties";

	//Creates a File Object based off a database File
	public int createFile(int fileID, String fname, int reqID, String fileURL) {
		int fileVal = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO FILES (FILE_ID, FILENAME, REQUEST_ID, FILE_URL) "
					+" VALUES(FILE_NUM_SEQ.NEXTVAL,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  fname);
			pstmt.setInt(2,  reqID);
			pstmt.setString(3,  fileURL);
			fileVal = pstmt.executeUpdate();
		con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return fileVal;
	}

	//Retrieves a File by ID
	public Files getFileByID(int fileID) {
		PreparedStatement pstmt = null;
		Files files = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM FILES WHERE FILE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fileID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int fID = rs.getInt("FILE_ID");
				String fname = rs.getString("FILENAME");
				int reqID = rs.getInt("REQUEST_ID");
				String fileURL = rs.getString("FILE_URL");
				files = new Files(fID, fname, reqID, fileURL);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return files;
	}

}
