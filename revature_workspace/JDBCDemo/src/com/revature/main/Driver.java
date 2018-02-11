package com.revature.main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.BearDaoXMLImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String [] args)
	{
		BearDao bd = new BearDaoXMLImpl();
		bd.getBears();
		//Breaking the dao pattern with this.
		Bear b2 = ((BearDaoXMLImpl)bd).unmarshallBear("src/BearToUnmarshall.xml");
		System.out.println(b.toString());
		/*
		
		CaveDao cd = new CaveDaoImpl();
		Calendar cal = Calendar.getInstance();
		cal.set(cal.YEAR,2001);
		cal.set(cal.MONTH,cal.JANUARY);
		cal.set(cal.DATE,1);
		System.out.println(cd.getCaves().toString());
		System.out.println(cd.getCaveById(439));
		BearDao bdi= new BearDaoImpl();
		@SuppressWarnings({ "deprecation", "static-access" })
		//java.sql.Date date = java.sql.Date.valueOf(cal.get(cal.YEAR)+":"+cal.get(cal.MONTH)+":"+cal.get(cal.DAY_OF_MONTH));
		BearType bt = new BearType("Panda");
		Cave cv = new Cave("Reston",1);
		System.out.println(bdi.getBearById(1));
		bdi.feedBear(1,1,40);
	*/
	}
}
