package com.revature.main;

import java.io.IOException;
import java.sql.*;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		/*
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.getMetaData().getDriverName());
		
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		CaveDao cd = new CaveDaoImpl();
		//System.out.println(cd.getCaves().toString());
		System.out.println(cd.getCaveById(7).toString());

		
		Bear bear = new Bear("POOH", new Cave(7, "RESTON", 10), new BearType(20, "PANDA"), 350, 
				new java.util.Date(123456789L));
		BearDao bd = new BearDaoImpl();
		
		bd.createBear(bear);
		bd.feedBear(5, 5, 25);
		
	}

}
