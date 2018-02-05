package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {
	public static void main (String[] args) {
		/*
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.getMetaData().getDriverName());
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		/*
		CaveDao cd = new CaveDaoImpl();
		System.out.println(cd.getCaves().toString());*/
		/*
		CaveDao cd = new CaveDaoImpl();
		System.out.println(cd.getCaveById(10));*/
		Cave oldCave = new Cave(2, "RESTON", 10);
		BearType oldBearType = new BearType(1, "Grizzly");
		//Bear newBear = new Bear(2, oldBearType.getId() , "Fred", new LocalDate("01-29-1983"), 300, oldCave.getId() );
		BearDao bd = new BearDaoImpl();
		//System.out.println(bd.addBear(newBear));
	}
}
