package com.revature.JDBCBank;

import java.io.*;
import java.util.*;

import com.revature.JDBCBank.CheckLogin;
import com.revature.beans.*;
import com.revature.dao.*;

public class JDBCBank 
{
	private static Scanner sc = new Scanner(System.in);
	private static boolean creation_flag = true;
	private static BankuserDao bd = new BankuserDaoSQL();
	private static CheckLogin checkLogin = new CheckLogin(sc,bd);
	private static CreateUser createUser = new CreateUser(sc,bd);

	
    public static void main( String[] args )
    {
    	Userinfo cur_user = null;
    	while(creation_flag) {
	    	System.out.println("What would you like to do?");
			System.out.println("(1) Login");
			System.out.println("(2) Create a new user");
			System.out.println("(3) Exit");
			System.out.print("Enter selection: ");
			
			String in_ans = sc.next();
			
			switch(in_ans) {
			case "1":
				cur_user = checkLogin.userLogin();
				break;
			case "2":
				cur_user = createUser.newUser();
				break;
			case "3":
				creation_flag = false;
				break;
			default:
				System.out.println("Invalid input please try again");
					
			}
			System.out.println("here???");
			interact(cur_user);
    	}
    	System.out.println("Goodbye");
    	
    }
    
    public static void interact(Userinfo userinfo) {
    	
    	if (userinfo != null) {
	    	System.out.println("Welcome!");
	    	System.out.println("What would you like to do?");
	    	
	    	if (userinfo.getSuperuser()) {
				System.out.println("(0) Super user stuff ;)");
			}
	    	
			System.out.println("(1) Create Account");
			System.out.println("(2) Delete Account (if empty)");
			System.out.println("(3) View accounts");
			System.out.println("(4) Withdraw");
			System.out.println("(5) Deposit");
			System.out.println("(5) Logout");
			System.out.print("Enter selection: ");
			
			String in_ans = sc.next();
    	}
    	
    }
    

}
