package com.revature.Driver;

import com.revature.dao.*;
import com.revature.util.ConnectionUtil;

import java.io.*;
import java.sql.*;

public class Driver {
	
	public static void main(String[] args) {
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {

//			String sql = "insert into images(image_name,image) values(?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			FileInputStream imageInputStream = new FileInputStream(new File("naruto.jpg"));
//            // inform the statement that first parameter in the query is of binary type
//			ps.setString(1, "helpme");
//			ps.setBinaryStream(2, imageInputStream);
//			ps.executeUpdate();
			
			String sql2 = "select image from images where image_name='helpme' ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			InputStream in = null;
			OutputStream out = null;
			while(rs.next()) {
				in = rs.getBinaryStream(1);
				out = new FileOutputStream(new File("fromdb.jpg"));
				int c = 0;
				while((c=in.read()) != -1) {
					out.write(c);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
