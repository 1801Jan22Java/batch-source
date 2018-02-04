package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String [] args ) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			System.out.println(con.getMetaData().getDriverName());
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
