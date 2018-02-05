package com.revature.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.SecurityDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String [] args) {
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			//System.out.println(con.getMetaData().getDriverName());
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		program();
		
	}
	public static void program() {
		Display dis = new Display();
		Scanner in = new Scanner(System.in);
		String choice;
		int result = 3;
		do {			
			dis.mainMenu();
			choice = in.next();			
			try {
				 result= Integer.parseInt(choice);
			}catch(Exception e) {
				System.out.println("Please enter one of the options");
			}	
			
			
			if(result == 1) {
				dis.newAccount();
			}else if(result == 2) {
				dis.verify_User();
			}else {
				System.out.println("Goodbye");
			}
		}while(result != 0);
	}

}
