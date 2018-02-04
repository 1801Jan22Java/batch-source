package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.util.ConnectionUtil;
// This is the bad way to do this because when you push you code to git everyone is going to see all of your 
// credentials hard coded into it 
// not secure and tightly coupled 
public class Driver {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			System.out.println(con.getMetaData().getDriverName());
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		}
		/*CaveDao cd = new CaveDaoImpl();
		System.out.println(cd.getCaves().toString());
		System.out.println(cd.getCaveById(7).toString());*/
		

	}

}
