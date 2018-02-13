package com.revature.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.*;

public class Driver {
	
	public static void main(String [] args) {
		
		FileInputStream fis = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			con.setAutoCommit(false);
			String sql = "insert into reimbursement(reimbursement_id,employee_id,manager_id,status_id,image) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			File image = new File("naruto.jpg");
			fis = new FileInputStream(image);
			ps.setBinaryStream(1, fis);
			System.out.println("reeeee");
			ps.execute();
			System.out.println("success?");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("welp");
		}
	}

}
