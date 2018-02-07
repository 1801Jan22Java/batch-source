package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOImpl;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
//		Connection con = null;
//		
//		try {
//			con = ConnectionUtil.getConnectionFromFile("connection.properties");
//			System.out.println(con.getMetaData().getDriverName());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		CaveDAO cd = new CaveDAOImpl();
//		System.out.println(cd.getCaves().toString());
//		System.out.println(cd.getCaveById(7).toString());
		
		BearType bearType = new BearType(1, "Grizzly");
		BearDAO bear = new BearDAOImpl();
		
		Bear b = new Bear(1, "Bob", cd.getCaveById(7), bearType, 150, new Date());
		bear.addBear(b);
	}

}
