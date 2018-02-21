package com.revature.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {
	public static void main(String args[]) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			//System.out.println(con.getMetaData().getDriverName());
		}catch(SQLException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD");
		LocalDate date_now = LocalDate.now();
		
		Date current_date =Date.valueOf(date_now);
		System.out.println(current_date);
		
		RequestDaoImpl req = new RequestDaoImpl();
		
		req.createRequest(9, "fjkdlsjflajiejlafdkljalfjdkl", 10.5);*/
		
		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD");
		LocalDate date_now = LocalDate.now();
		
		Date current_date =Date.valueOf(date_now);
		System.out.println(current_date);*/
		/*EmployeeDaoImpl emp = new EmployeeDaoImpl();
		System.out.println(emp.getAuthorization("MK123", "123"));*/
	}
		
	}
