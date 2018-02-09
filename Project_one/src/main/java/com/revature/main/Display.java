package com.revature.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.AccountsDaoImpl;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.SecurityDaoImpl;
import com.revature.util.ConnectionUtil;

public class Display {
	private String username;
	private String password;
	private String super_user = "SuperUser.properties";
	Scanner in = new Scanner(System.in);
	SecurityDaoImpl security = new SecurityDaoImpl();
	AccountsDaoImpl accounts = new AccountsDaoImpl();
	CustomerDaoImpl customer = new CustomerDaoImpl();
	ConnectionUtil con = new ConnectionUtil();
	private String super_file = "SuperUser.properties";

	public void mainMenu() {
		System.out.println("Hello welcome to McBank what would you like to do" + "\n Press 1 to open an account"
				+ "\n Press 2 to check on existing account" + "\n Press 0 to exit\n");
	}

	public void newAccount() {
		SecurityDaoImpl security = new SecurityDaoImpl();
		CustomerDaoImpl customer = new CustomerDaoImpl();
		String f_name, l_name, username = null, password;
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
		System.out.println("A new account was created please log in with your new credentials \n");
	}

	public void checkExisting() {
		int result = 0;
		main:
		do {
			System.out.println("What would you like to do "+ security.getFirst_Name()+ "?\n 1.) Check on existing account "
					+ "\n 2.) Add funds to an account" + "\n 3.) Withdraw funds from an account"
					+ "\n 4.) Delete your account " + "\n 0.) Log out ");
			try {
				result = in.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter a valid option");
			}

			switch (result) {
			case 1: {
				System.out.println("Your account "+security.getAccount_Number()+ " has a balance of $" + accounts.getBalance() + " dollars\n");
				break;
			}
			case 2: {
				double amount;
				boolean proper_amount = false;
				boolean finished = false;
				int choice = 0;


						System.out.println("How much would you like to add today: ");

						try {
							amount = Double.parseDouble(in.next());
							accounts.addFunds(amount);
							proper_amount = true;
						} catch (Exception e) {
							System.out.println("Please enter a valid amount");
						}

				break;
			}

			case 3: {
				double amount;
				boolean proper_amount = false;
				boolean finished = false;
				int choice = 0;

						System.out.println("How much would you like to withdraw today: ");

						try {
							amount = Double.parseDouble(in.next());
							accounts.removeFunds(amount);
							proper_amount = true;
						} catch (Exception e) {
							System.out.println("Please enter a valid amount");
							proper_amount = true;
							break;
						}

				break;
			}
			case 4: {
				int choice4 = 5;
				System.out.println("Are you sure?"
						+ "\n 1.) Yes"
						+ "\n 2.) No");
				try {
					choice4 = in.nextInt();
					if(choice4 == 1) {
						accounts.deleteAccount(security.getUserID());
						System.out.println("Your account has been deleted");
						
					}
					else if(choice4 ==2) {
						System.out.println("Your account has not been deleted");
					}
				}catch(Exception e) {
					System.out.println("You have not entered a valid option");
				}
				break main;

			}
			case 0: {
				break;
			}
			default: {
				break;
			}
			}
		} while (result != 0);

	}

	public void verify_User() {

		boolean verify = false;
		boolean super_user = false;
		int count = 0;
		int choice=5;

		do {
			while (verify == false) {
				System.out.println("Please enter your username: ");
				username = in.next();
				System.out.println("Please enter your password: ");
				password = in.next();
				// System.out.println(username + " "+ password);
				try {
					if (username.equals(con.getSuperUser_Username(super_file))
							&& password.equals(con.getSuperUser_Password(super_file))) {
						super_user = true;
						verify = true;

						break;

					}else {
						verify = security.check_Credentials(username, password);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(verify == false) {
				System.out.println("You have entered an invalid password you have "+ (3 - count-1) +" attempts remaining");
				count+=1;
				}
				if (count == 3) {
					System.out.println("You have no more attempts please try again later\n");
					verify = false;
					break;
				}
				
			}
			if (verify == true) {

				break;
			}else if(count >=3) {
				break;
				
			}
			

		} while (verify == false);

		if (super_user == true) {
			this.Super_User();
		} else if(verify == true) {
			this.checkExisting();
		}

	}

	public void Super_User () {
		Scanner in = new Scanner(System.in);
		int choice = 5;
		do {
			System.out.println("What would you like to do today"
					+ "\n 1.) View accounts "
					+ "\n 2.) Create an account "
					+ "\n 3.) Update an account "
					+ "\n 4.) delete a user"
					+ "\n 0.) Exit");
			
			try {
				choice = in.nextInt();
			}catch(Exception e) {
				System.out.println("Please enter a valid option");
			}
			switch(choice) {
			case 1: {
				int accountNumber = 0;
				boolean check_AccountNumber = false;
				System.out.println("Which account would you like to View?");
				
				try {
					accountNumber = Integer.parseInt(in.next()) ;
				}catch(Exception e) {
					System.out.println("Please enter a valid account number");
				}
				
				
				if(security.check_AccountNumber(accountNumber)) {
					System.out.println("That account has a balance of: "+accounts.getBalance_Super(accountNumber));
				}else {
					System.out.println("You entered an invalid account number");
				}
				break;
			}
			
			case 2:{
				String f_name, l_name, username = null, password;
				boolean username_availability = false;

				do {
					while (username_availability == false) {
						System.out.println("Please enter the new username: ");
						username = in.next();

						username_availability = security.check_Availability(username);
						if (username_availability == false) {
							System.out.println("The username entered was not valid");
						}

					}

				} while (username_availability != true);
				System.out.println("Please enter the user password: ");
				password = in.next();
				System.out.println("Please enter the user first name: ");
				f_name = in.next();
				System.out.println("Please enter the user last name: ");
				l_name = in.next();

				customer.addCustomer_Super(f_name, l_name, username, password);
				System.out.println("Account was created");
				break;
				
			}
			case 3: {
				int accountNumber = 0;
				int action = 0;
				int money = 0;
				System.out.println("Which account will you be working with today?");
				try {
					accountNumber = Integer.parseInt(in.next()) ;
				}catch(Exception e) {
					System.out.println("Please enter a valid account number");
				}
				
				if(security.check_AccountNumber(accountNumber)) {
					
					System.out.println("What would you like to do"
							+ "\n 1.) Add funds "
							+ "\n 2.) Remove funds");
					try {
						action  = in.nextInt();
					}catch(Exception e) {
						System.out.println("Please enter a valid option");
					}
					if(action == 1) {
						System.out.println("How much would yo like to add?");
						try {
							accounts.addFunds_Super(accountNumber,in.nextDouble() );
						}catch(Exception e) {
							System.out.println("Please enter a valid amount");
						}
						
					}else if (action == 2) {
						System.out.println("How much would yo like to remove?");
						try {
							accounts.removeFunds_Super(accountNumber,in.nextDouble() );
						}catch(Exception e) {
							System.out.println("Please enter a valid amount");
						}
					}else {
						System.out.println("You did not choose a valid option");
					}
					
				}else {
					System.out.println("You entered an invalid account number");
				}
				break;				
			}
			
			case 4: {
					int accountNumber = 0;
					int action = 0;
					int money = 0;
					System.out.println("Which account would you like to delete?");
					try {
						accountNumber = Integer.parseInt(in.next()) ;
					}catch(Exception e) {
						System.out.println("Please enter a valid account number");
					}
					
					if(security.check_AccountNumber(accountNumber)) {
						accounts.deleteAccount_Super(accountNumber);
					}else {
						System.out.println("The number you entered was not valid");
					}
					break;
					
				}
				case 0:{
					System.out.println("Goodbye");
					break;
				}
				default: {
					System.out.println("You did not enter a valid option");
					break;
				}
				
			}
		}while(choice != 0 );
	}

}
