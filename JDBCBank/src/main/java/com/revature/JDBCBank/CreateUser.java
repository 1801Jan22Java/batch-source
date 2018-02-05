package com.revature.JDBCBank;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.util.CheckUtilities;

public class CreateUser {
	
	private static Scanner sc;
	private static BankuserDao bd;
	private static boolean user_flag = true;
	
	public CreateUser() {
		super();
	}
	
	public CreateUser(Scanner sc, BankuserDao bd) {
		this.sc = sc;
		this.bd = bd;
	}
	
	public Userinfo newSuperUser(String user, String pass) {
		
		Userinfo new_user = null;
		
		while(user_flag) {
			System.out.print("(required)Enter SSN: ");
			String in_ssn = sc.next();
			if(checkEmpty(in_ssn)) {
				System.out.println("Empty SSN");
				continue;
			}
			System.out.print("(required)Enter first name: ");
			String fname = sc.next();
			if(checkEmpty(fname)) {
				System.out.println("Empty firstname");
				continue;
			}
			System.out.print("(required)Enter last name: ");
			String lname = sc.next();
			if(checkEmpty(lname)) {
				System.out.println("Empty lastname");
				continue;
			}
			System.out.print("(requires)Enter address: ");
			String in_adr = sc.next();

			System.out.print("(required)Enter an email: ");
			String in_email = sc.next();
			if(checkEmpty(in_email)) {
				System.out.println("empty password");
				continue;
			}
			user_flag = false;
			UserinfoDao userinfoDao = new UserinfoDaoSQL();
			int id = userinfoDao.addUserinfo(user, pass, in_ssn, fname, lname, in_adr, in_email);
			System.out.println("Successfully added user!");
			new_user = userinfoDao.getUserinfoByID(id);
			new_user.setSuperuser(true);
			
		}
		
		return new_user;
		
		
	}
	
	public Userinfo newUser() {
	
		Userinfo new_user = null;
		while(user_flag) {
			System.out.print("(required)Enter a username: ");
			String in_user = sc.next();
			if(checkEmpty(in_user)) {
				System.out.println("Empty username");
				continue;
			}
			
			if (!CheckUtilities.checkUser(in_user,bd)) {
				
				System.out.print("(required)Enter a password: ");
				String in_pass = sc.next();
				if(checkEmpty(in_pass)) {
					System.out.println("Empty Password");
					continue;
				}
				System.out.print("(required)Enter SSN: ");
				String in_ssn = sc.next();
				if(checkEmpty(in_ssn)) {
					System.out.println("Empty SSN");
					continue;
				}
				System.out.print("(required)Enter first name: ");
				String fname = sc.next();
				if(checkEmpty(fname)) {
					System.out.println("Empty firstname");
					continue;
				}
				System.out.print("(required)Enter last name: ");
				String lname = sc.next();
				if(checkEmpty(lname)) {
					System.out.println("Empty lastname");
					continue;
				}
				System.out.print("(required)Enter address: ");
				String in_adr = sc.next();

				System.out.print("(required)Enter an email: ");
				String in_email = sc.next();
				if(checkEmpty(in_email)) {
					System.out.println("empty password");
					continue;
				}
				user_flag = false;
				UserinfoDao userinfoDao = new UserinfoDaoSQL();
				int id = userinfoDao.addUserinfo(in_user, in_pass, in_ssn, fname, lname, in_adr, in_email);
				System.out.println("Successfully added user!");
				new_user = userinfoDao.getUserinfoByID(id);
				

			}
			else {
				System.out.println("Username taken. Please try again");
			}
		}
		return new_user;
	}
	
	
	private boolean checkEmpty(String str) {
		if (str.equals("")) {
			return true;
		}
		return false;
	}
}
