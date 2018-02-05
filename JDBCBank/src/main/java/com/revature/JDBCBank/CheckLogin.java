package com.revature.JDBCBank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.revature.beans.*;
import com.revature.dao.BankuserDao;
import com.revature.dao.BankuserDaoSQL;
import com.revature.dao.UserinfoDao;
import com.revature.dao.UserinfoDaoSQL;
import com.revature.util.CheckUtilities;

public class CheckLogin {
	
	private static Scanner sc;
	private static CreateUser createUser;
	private static BankuserDao bd;
	private static boolean creation_flag = true;
	private static boolean login_flag = true;
	private static boolean super_flag = false;
	private static String s_user = null;
	private static String s_pass = null;
	
	public CheckLogin() {
		super();
	}
	public CheckLogin(Scanner sc,BankuserDao bd) {
		super();
		CheckLogin.sc = sc;
		CheckLogin.bd = bd;
		createUser = new CreateUser(sc,bd);
		try {
			InputStream in = new FileInputStream("super.properties");
			Properties prop = new Properties();
			prop.load(in);
			s_user = prop.getProperty("superuser");
			s_pass = prop.getProperty("superpass");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Userinfo getUser(String user) {
		
		int id = -1;
		
		List<Bankuser> resultBankusers = bd.getBankusers();
		
		for (Bankuser b : resultBankusers) {
			
			if (b.getBankuser().equals(user)) {
				id = b.getBankuserID();
			}
		}
		
		Userinfo get_user = null;
		UserinfoDao userinfoDao = new UserinfoDaoSQL();
		List<Userinfo> resultUserinfo = userinfoDao.getUserinfo();
		
		for (Userinfo u : resultUserinfo) {
			
			if (u.getBankuserID() == id) {
				get_user = u;
			}
		}
		
		return get_user;
	}

    public Userinfo userLogin() {
    	
    	Userinfo cur_user = null;
    	
    	while(login_flag) {
    		
	    	System.out.print("Enter Username: ");
			
			String in_user = sc.next();
			
			System.out.print("\nEnter Password: ");
			
			String in_pass = sc.next();
			
			if(in_user.equals(s_user) && in_pass.equals(s_pass)) {
				System.out.println("Welcome super user!");
				super_flag = true;
			}
			
			if(CheckUtilities.checkUser(in_user,bd)) {
				
				if(CheckUtilities.checkPassword(in_pass,bd)) {
					cur_user = getUser(in_user);
					if (super_flag) {
						cur_user.setSuperuser(true);
					}
					login_flag = false;
				}
				else {
					System.out.println("Incorrect User/password combination. Please try again :)");
				}
				
			}
			
			else {
				if (super_flag) {
					System.out.println("It is your first time logging in, please create an account with the same username/password");
					cur_user = createUser.newSuperUser(in_user, in_pass);
					login_flag = false;
					
				}
				else {
					System.out.println("Username not found :(");
					System.out.print("Would you like to continue? [Y/N]: ");
					String in_ans = sc.next();
					if (!(in_ans.toUpperCase()).equals("Y")) {
						login_flag = false;
					}
				}
				
			}

    	}
    	
    	return cur_user;
    	
    }

    
}
