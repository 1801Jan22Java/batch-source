package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		Connection con = null;

		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.getMetaData().getDriverName());
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//CaveDao cd = new CaveDaoImpl();
		//System.out.println(cd.getCaveByID(1));
		
		BearDao bd = new BearDaoImpl();
		bd.getBearByID(1);
	}

}
