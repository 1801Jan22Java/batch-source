package com.revature.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.*;

public class Driver {

	public static void main(String [] args) {

		FileInputStream fis = null;

		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			con.setAutoCommit(false);
			String sql2 = "select image from reimbursement where reimbursement_id = 1003";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			InputStream in = null;
			OutputStream out = null;
			while(rs.next()) {
				in = rs.getBinaryStream(1);
				out = new FileOutputStream(new File("ahhh.jpg"));
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
