package com.revature.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Admin;
import com.revature.beans.User;
import com.revature.dao.UserDaoImpl;

public class Driver {

	private static Scanner input = new Scanner(System.in);
	
	private static UserDaoImpl udi = new UserDaoImpl();
	
	
	public static void main(String[] args) {
		
		drive();							
		
	}
	
	// Navigation method for the User. Functions with the use of
	// nested do-while loops with switch statements and through a Scanner object
	private static void drive() {
		
		// Selection variables
		int doSelection = -1; // int variable to be used for switch statement
		String doSelectionString; // String variable to read in nextLine() from the Scanner,
									// this String is parsed into an int

		// do-while loop to allow the user to navigate between Login, Create Account,
		// and Exiting the program
		do {
			try {
				
				ArrayList<User> users = udi.getUsers();	
				Admin admin = new Admin("admin", "admin");	// TODO: get the SuperUser credentials 
															// from the file and instantiate
				users.add(admin);

				System.out.println("\n=======================Login Screen=======================");
				System.out.println("Select an option:");
				System.out.println("1 - Login \n2 - Create Account \n0 - Exit");

				doSelectionString = input.nextLine();
				doSelection = Integer.parseInt(doSelectionString);

				switch (doSelection) {
				case 0:
					return;
				case 1:
					doLogin(users);
					break;
				case 2:
					doCreateUser(users);
					break;
				default:
					System.out.println("Invalid input! Try again.");
					break;

				}

			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid input!");
			}

		} while (true);
	}
	
	
	// TODO: wherever setUsers is called should be updating database, then should be calling getUsers
	
	
	private static void doCreateUser(ArrayList<User> users) {
		
		System.out.println("Create a username:");
		String username = input.nextLine(); // Read in username from Scanner
		username = username.trim(); // trim spaces before and after the username
		if (username.equals("")) { // Exit method if a blank username entered
			System.out.println("New user creation canceled");
			return;
		}
		System.out.println("Create a password: ");
		String password = input.nextLine();
		if (password.equals("")) {
			System.out.println("New user creation canceled");
			return;
		}

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(username)) {
				System.out.println("Username already exists!");
				return;
			}
		}

		udi.insertNewUser(username, password);
					
		System.out.println("User account created!");
	}
	
	// Display options after logging in. Perform methods as prompted by the user
	// TODO: Add check to ensure that Username and Password do not have over 100 characters, return; if yes
	private static void doLogin(ArrayList<User> users) {
		User loggedInUser = null;
		int loggedInUserIndex = -1;
		System.out.println("Enter username: ");
		String username = input.nextLine();
		System.out.println("Enter password: ");
		String password = input.nextLine();
		
/*		ArrayList<User> users = udi.getUsers();	
		
		Admin admin = new Admin("admin", "admin");	// TODO: get the SuperUser credentials 
													// from the file and instantiate
		users.add(admin);*/
		
		for (int i = 0; i < users.size(); i++) {
			if (username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())) {
				loggedInUser = users.get(i); // Create a copy of the matching object if exists
				loggedInUserIndex = i; // Store index of the matching object
				break;
			}
		}
		// Execute if loggedInUser is still null after going through for loop
		if (loggedInUser == null) {
			System.out.println("Invalid login!");
			return;
		}

		// Execute the following if statement if the user is an admin.
		// the if statement contains, a switch statement with do-while loops for most
		// cases
		
		//TODO: this should be the User screen, should have an (!(loggedInUser instanceof Admin)) check
		if (!(loggedInUser instanceof Admin)) {

			int doAdminSelection = -1;
			String doAdminSelectionString;

			do {
				try {
					System.out.println("\n============================================================Transaction Screen"
							+ "============================================================");
					System.out.println("Current checkings balance: $" + loggedInUser.getCheckingsBalance());
					System.out.println("Current savings balance: $" + loggedInUser.getSavingsBalance());
					System.out.println("Select an option:");
					System.out.println("1 - Deposit into Checkings \n2 - Deposit into Savings "
							+ "\n3 - Withdraw from Checkings \n4 - Withdraw from Savings "
							+ "\n5 - Transfer from Checkings to Savings \n6 - Transfer from Savings to Checkings "
							+ "\n0 - Logout");

					doAdminSelectionString = input.nextLine();
					doAdminSelection = Integer.parseInt(doAdminSelectionString);

					switch (doAdminSelection) {
					case 0: // Logout
						return;
					case 1: // Deposit into Checkings
						double checkingsDepositAmount = 0;
						String checkingsDepositAmountString;
						do {
							try {
								System.out.println("Enter deposit amount: ");

								checkingsDepositAmountString = input.nextLine();
								checkingsDepositAmount = Double.parseDouble(checkingsDepositAmountString);

								break;

							} catch (NumberFormatException ex) {
								System.out.println("Please enter a valid input!");
							}
						} while (true);

						loggedInUser.depositIntoCheckings(checkingsDepositAmount);
						users.set(loggedInUserIndex, loggedInUser); // Replace old instance of the user to save updated
																	// balance

						break;
						
					case 2: // Deposit into Savings
						double savingsDepositAmount = 0;
						String savingsDepositAmountString;
						do {
							try {
								System.out.println("Enter deposit amount: ");

								savingsDepositAmountString = input.nextLine();
								savingsDepositAmount = Double.parseDouble(savingsDepositAmountString);

								break;

							} catch (NumberFormatException ex) {
								System.out.println("Please enter a valid input!");
							}
						} while (true);

						loggedInUser.depositIntoSavings(savingsDepositAmount);
						users.set(loggedInUserIndex, loggedInUser); // Replace old instance of the user to save updated
																	// balance
						break;
						
					
					case 3: // Withdraw from Checkings
						double checkingsWithdrawAmount = 0;
						String checkingsWithdrawAmountString;
						do {
							try {
								System.out.println("Enter withdraw amount: ");

								checkingsWithdrawAmountString = input.nextLine();
								checkingsWithdrawAmount = Double.parseDouble(checkingsWithdrawAmountString);

								break;

							} catch (NumberFormatException ex) {
								System.out.println("Please enter a valid input!");
							}
						} while (true);

						loggedInUser.withdrawFromCheckings(checkingsWithdrawAmount);
						users.set(loggedInUserIndex, loggedInUser); // Replace old instance of the user to save updated
																	// balance

						break;

					case 4:					
						double savingsWithdrawAmount = 0;
						String savingsWithdrawAmountString;
						do {
							try {
								System.out.println("Enter withdraw amount: ");

								savingsWithdrawAmountString = input.nextLine();
								savingsWithdrawAmount = Double.parseDouble(savingsWithdrawAmountString);

								break;

							} catch (NumberFormatException ex) {
								System.out.println("Please enter a valid input!");
							}
						} while (true);

						loggedInUser.withdrawFromSavings(savingsWithdrawAmount);
						users.set(loggedInUserIndex, loggedInUser); // Replace old instance of the user to save updated
																	// balance

						break;
						
					case 5:					// TODO: Transfer from Checkings to Savings	
						double transferCheckingsToSavingsAmount = 0;
						String transferCheckingsToSavingsAmountString;
						do {
							try {
								System.out.println("Enter withdraw amount: ");

								transferCheckingsToSavingsAmountString = input.nextLine();
								transferCheckingsToSavingsAmount = Double.parseDouble(transferCheckingsToSavingsAmountString);

								break;

							} catch (NumberFormatException ex) {
								System.out.println("Please enter a valid input!");
							}
						} while (true);
						
						loggedInUser.transferFromCheckingsToSavings(transferCheckingsToSavingsAmount);
						users.set(loggedInUserIndex, loggedInUser); // Replace old instance of the user to save updated
																	// balance
						break;
						
					case 6:					// TODO: Transfer from Savings to Checkings	
						
						double transferSavingsToCheckingsAmount = 0;
						String transferSavingsToCheckingsAmountString;
						do {
							try {
								System.out.println("Enter withdraw amount: ");

								transferSavingsToCheckingsAmountString = input.nextLine();
								transferSavingsToCheckingsAmount = Double.parseDouble(transferSavingsToCheckingsAmountString);

								break;

							} catch (NumberFormatException ex) {
								System.out.println("Please enter a valid input!");
							}
						} while (true);
						
						loggedInUser.transferFromSavingsToCheckings(transferSavingsToCheckingsAmount);
						users.set(loggedInUserIndex, loggedInUser); // Replace old instance of the user to save updated
																	// balance
						break;

					default:
						System.out.println("Invalid input! Try again.");
						break;

					}

				} catch (NumberFormatException ex) {
					System.out.println("Please enter a valid input!");
				}

			} while (true);
		}
		
		// TODO: SuperUser methods here
		// Case 1: View users
		// Case 2: Create a User (call create doCreateUser here)
		// Case 3: Update user (update password)
		// Case 4: Delete all users (ONLY delete users with a 0 balance in both accounts)
		
		else {

			int doUserSelection = -1;
			String doUserSelectionString;

			do {
				try {
					System.out.println("\n=============================User Screen=============================");
					System.out.println("Select an option:");
					System.out.println("1 - View Users \n2 - Create UserAccount \n3 - Update User "
							+ "\n4 - Delete Users With 0 Balnce \n0 - Logout");

					doUserSelectionString = input.nextLine();
					doUserSelection = Integer.parseInt(doUserSelectionString);

					switch (doUserSelection) {
					case 0: // TODO: Logout
						return;
					case 1: // TODO: View Users
						
						break;

					case 2: // TODO: Create User

						break;

					case 3: // TODO: Update User
						break;
						
					case 4: // TODO: Delete Users with 0 balance

					default:
						System.out.println("Invalid input! Try again.");
						break;

					}

				} catch (NumberFormatException ex) {
					System.out.println("Please enter a valid input!");
				}

			} while (true);

		}
	}
	
}
