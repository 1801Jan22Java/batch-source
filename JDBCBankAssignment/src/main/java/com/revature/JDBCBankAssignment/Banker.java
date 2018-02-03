package com.revature.JDBCBankAssignment;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.util.ConnectionUtil;

public class Banker {

	Scanner inputScan;
	
	public Banker() {
		//Init scanner to get user input
		inputScan = new Scanner(System.in);
	}
	
	public boolean init() {
		//Connect to database, do not continue with program if unable to do so
        try {
        	System.out.println("Connecting to banking server...");
			ConnectionUtil.connectToDatabase("Connection.Properties");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to connect to database!");
			return false;
		}
        
        System.out.println("Connection to bank servers success!");
        return true;
	}
	
	public void run() {
		
		userLoop();
		
		ConnectionUtil.disconnect();
	}
	
	//Root control of user input
	private void userLoop() {
		homeScreen();
	}
	
	//Here user can login, register, or exit
	private void homeScreen() {
		System.out.println("----------------------------------");
		System.out.println("Welcome to the best bank there is!");
		System.out.println("----------------------------------");
		boolean exit = false;
		
		while(!exit) {
			switch(getUserChoice("Login[1], Register[2], Exit[3]", 1 , 3)){
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			default:
			case 3:
				System.out.println("Exiting...");
				exit = true;
				
			}
		}
	}
	
	//User is logging in
	private void login() {
		
		String username = getUserString("Enter username: ", 5, 20);
		String password = getUserString("Enter password: ", 5, 20);
		
		UserDao dao = new UserDaoImpl();
		User user = dao.login(username, password);
		
		if(user != null) {
			System.out.println(user.getId());
		}
		else
			System.out.println("Invalid login credentials!");
	}
	
	//User is registering an account
	private void register() {
		
		String username = getUserString("Enter username: ", 5, 20);
		String password = getUserString("Enter password: ", 5, 20);
		
		UserDao dao = new UserDaoImpl();
		dao.register(username, password);
	}
	
	//Propts users to select from a list of options
	private int getUserChoice(String prompt, int lowChoice, int highChoice) {
		
		int choice = -1;
		String input;
		
		//Input validation loops
		while(choice < lowChoice || choice > highChoice) {
			//Prompt user for input
			System.out.println(prompt);
			
			input = inputScan.nextLine();
			
			try {
			choice = Integer.parseInt(input);
			}catch(NumberFormatException e) {
				choice = -1;
			}
			
			if(choice < lowChoice || choice > highChoice) System.out.println("Invalid option!");
		}
		
		return choice;
	}
	
	private String getUserString(String prompt, int minLength, int maxLength) {
		
		String input = "";
		while(input.length() < minLength || input.length() > maxLength) {
			
			System.out.println(prompt);
			
			input = inputScan.nextLine();
			
			if(input.length() < minLength || input.length() > maxLength)
				System.out.println("Error: Must be between " + minLength + " and " +  maxLength + " characters!");
			else if(input.contains(" ")) {
				System.out.println("Error: Can not contain spaces!");
				input = "";
			}
		}
		
		return input;
	}
}
