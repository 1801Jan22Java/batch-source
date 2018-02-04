package com.revature.main;

import java.util.Scanner;

import com.revature.dao.AccountsDaoImpl;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.SecurityDaoImpl;

public class Display {
	private String username;
	private String password;
	Scanner in = new Scanner(System.in);
	SecurityDaoImpl security = new SecurityDaoImpl();
	AccountsDaoImpl accounts = new AccountsDaoImpl();

	public void mainMenu() {
		System.out.println("Hello welcome to McBank what would you like to do" + "\n Press 1 to open an accout"
				+ "\n Press 2 to check on existing account" + "\n Press 0 to exit\n");
	}

	public void newAccount() {
		SecurityDaoImpl security = new SecurityDaoImpl();
		CustomerDaoImpl customer = new CustomerDaoImpl();
		String f_name, l_name, username=null, password;
		boolean username_availability = false;

		do {
			while (username_availability == false) {
			System.out.println("Please enter your new username: ");
			username = in.next();
			
				username_availability = security.check_Availability(username);
				if (username_availability == false) {
					System.out.println("The username entered was not valid");
				}
			}

		} while (username_availability != true);
		System.out.println("Please enter your password: ");
		password = in.next();
		System.out.println("Please enter your first name: ");
		f_name = in.next();
		System.out.println("Please enter your last name: ");
		l_name = in.next();

		customer.addCustomer(f_name, l_name, username, password);

	}

	public void checkExisting() {
		int result = 0;

		do {
			System.out.println("What would you like to do" + "\n 1.) Check on existing account "
					+ "\n 2.) Add funds to an account" + "\n 3.) Withdraw funds from an account"
					+ "\n 4.) Delete your account " + "\n 0.) Log out ");
			try {
				result = in.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter a valid option");
			}

			switch (result) {
			case 1:{
				System.out.println("Your account has a balance of $"+accounts.getBalance()+" dollars");
				break;
			}
			case 2: {
				double amount;
				boolean proper_amount = false;
				boolean finished = false;
				int choice = 0;

				while (finished != true) {

					do {
						System.out.println("How much would you like to add today: ");

						try {
							amount = Double.parseDouble(in.next());
							accounts.addFunds(amount);
							proper_amount = true;
						} catch (Exception e) {
							System.out.println("Please enter a valid amount");
						}
					} while (proper_amount = false);

					System.out.println("Would you like to add more?" + "\n 1.) Yes " + "\n 2.) No");
					choice = in.nextInt();
					if (choice == 1) {
					} else {
						finished = true;
						break;
					}
				}
				break;
			}

			case 3: {
				double amount;
				boolean proper_amount = false;
				boolean finished = false;
				int choice = 0;

				while (finished != true) {

					do {
						System.out.println("How much would you like to withdraw today: ");

						try {
							amount = Double.parseDouble(in.next());
							accounts.removeFunds(amount);
							proper_amount = true;
						} catch (Exception e) {
							System.out.println("Please enter a valid amount");
						}
					} while (proper_amount = false);

					System.out.println("Would you like to add more?" + "\n 1.) Yes " + "\n 2.) No");
					choice = in.nextInt();
					if (choice == 1) {
					} else if (choice ==2) {
						finished = true;
						break;
					}
				}
				break;
			}
			case 4:{
				accounts.deleteAccount();
				System.out.println("Your account has been deleted");
				
			}
			case 0:{
				break;
			}
			default:{
				break;
			}
			}
		} while (result != 0);

	}

	public void verify_User() {

		boolean verify = false;

		do {
			while (verify == false) {
				System.out.println("Please enter your username: ");
				username = in.next();
				System.out.println("Please enter your password: ");
				password = in.next();
				// System.out.println(username + " "+ password);
				System.out.println(" verify result __________" + username);
				verify = security.check_Credentials(username, password);
				System.out.println(" verify result __________" + verify);
			}
			if (verify == true) {

				break;
			}
		} while (verify == false);

		this.checkExisting();

	}

}
