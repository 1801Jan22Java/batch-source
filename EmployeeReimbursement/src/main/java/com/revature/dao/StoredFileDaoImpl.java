package com.revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.StoredFile;
import com.revature.util.ConnectionUtil;

public class StoredFileDaoImpl implements StoredFileDao {

	@Override
	public void createStoredFile(String fileName, int requestID, InputStream fileContents) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STORED_FILE "
					+ "(FILE_NAME, REQUEST_ID, FILE_CONTENTS)"
					+ " VALUES (?,?,?)");
			

			pstmt.setString(1, fileName);
			pstmt.setInt(2, requestID);
			pstmt.setBlob(3, fileContents);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public StoredFile readStoredFile(int requestID) {
		StoredFile screenshot = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM STORED_FILE WHERE REQUEST_ID=?");
			

			pstmt.setInt(1, requestID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				screenshot = new StoredFile(rs.getInt("FILE_ID"), rs.getString("FILE_NAME"), rs.getInt("REQUEST_ID"));
				screenshot.setFileInStream(rs.getBinaryStream("FILE_CONTENTS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenshot;
	}
}
