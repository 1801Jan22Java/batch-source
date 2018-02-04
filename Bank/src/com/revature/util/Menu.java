package com.revature.util;

import java.util.Scanner;

public class Menu {

	public Menu()
	{
		super();
		startMenu();
	}
	
	/*
	 * 
	 */
	private void startMenu()
	{
		String input = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the JDBC banking app");
		System.out.println("Are you a returning user?");
		System.out.println("Type yes to log in, no if you need to create a username/password, or exit.");
		input = sc.nextLine();
		switch (input)
		{
			case "yes"://login break;
			case "no": //create login break;
			case "exit"://terminate program return;
				default: System.out.println("Sorry but that was not a valid input.");
		}
	}
	
	/*
	 * 
	 */
	private boolean createLogin()
	{
		//try to create login 
		//if username exists throw exception
		return false;
	}
	
	/*
	 * 
	 */
	private boolean login()
	{
		//try to log in 
		//if password is wrong it will throw an exception
		//if username doesnt exist it will throw exception
		return true;
	}
}
