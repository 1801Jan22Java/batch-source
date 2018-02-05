package com.revature.main;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.util.ConnectionUtil;
import com.revature.dao.*;
import com.revature.beans.*;

public class Driver {
	
	public static void main(String [] args ) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			System.out.println(con.getMetaData().getDriverName());
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i = 0;
		BankuserDao bd = new BankuserDaoSQL();
		bd.addBankuser("cheese1232", "please",i);
		List<Bankuser> result = bd.getBankusers();
		System.out.println(result.toString());
		
	}

}
