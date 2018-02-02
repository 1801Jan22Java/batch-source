package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.revature.beans.*;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
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
		
		CaveDao cd = new CaveDaoImpl();
		//System.out.println(cd.getCaves().toString());
		//System.out.println(cd.getCaveById(10));
		
		BearDao bd = new BearDaoImpl();
		/*List<Bear> bearList = bd.getBears();
		for (Bear b : bearList){
			System.out.println(b.toString());
		}*/
		
		//Bear joe = new Bear("Joe",new Cave(7,"Reston",10),new BearType(5,"Grizzly"),200, LocalDate.of(1992, 9, 5));
		
		//bd.buildABear(joe);
		//bd.feedBear(7, 7, 30);
		System.out.println(bd.getBearById(7));
		
		
	}

}
