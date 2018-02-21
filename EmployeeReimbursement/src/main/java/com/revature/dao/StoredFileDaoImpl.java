package com.revature.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletOutputStream;

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

				/*ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				Blob blob = rs.getBlob("FILE_CONTENTS");
				InputStream is = blob.getBinaryStream();
				int bytesRead = -1;
				byte[] buffer = new byte[1028];
				
				
				while((bytesRead = is.read(buffer)) != -1) {
					baos.write(buffer, 0, bytesRead);
				}
				
				screenshot.setImageBytes(baos.toByteArray());*/
				
				Blob blob = rs.getBlob("FILE_CONTENTS");
				byte blobArr[] = blob.getBytes(1, (int)blob.length());
				screenshot.setImageBytes(blobArr);
				
				FileOutputStream fos = new FileOutputStream(String.format("E:\\Work\\Revature\\Training\\Project 1\\Images\\%s", rs.getString("FILE_NAME")));
				fos.write(blobArr);
				
				fos.close();
			}
			return screenshot;
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
