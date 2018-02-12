package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.Bear;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.BearDaoXmlImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		/*
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			//System.out.println(con.getMetaData().getDriverName());
		} catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
//		
//		CaveDao cd = new CaveDaoImpl();
//		System.out.println(cd.getCaves().toString());
//		BearDaoImpl bdi = new BearDaoImpl();
//		bdi.insertBear(5, "hello", "1990/02/12", 500, 5);
		BearDao bd = new BearDaoXmlImpl();
//		bd.getBears();
		
		Bear b2 = ((BearDaoXmlImpl)bd).unmarshalBear("src/BearToUnmarshal.xml");
		System.out.println(b2.toString());
	}

}
