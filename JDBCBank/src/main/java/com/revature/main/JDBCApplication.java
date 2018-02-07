package com.revature.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Accounts;
import com.revature.beans.BankUsers;
import com.revature.dao.AccountOracle;
import com.revature.dao.UserOracle;
import com.revature.util.LoginNotValidException;

public class JDBCApplication {

	public static void main(String[] args) {

		boolean keepGoing = true;

		UserOracle userOps = null;
		AccountOracle accountOps = null;
		userOps = new UserOracle();
		accountOps = new AccountOracle();

		Scanner scanner = new Scanner(System.in);

		while (keepGoing) {
			// Login Menu
			System.out.println("1 - Login");
			System.out.println("2 - New User");
			System.out.println("3 - Exit");

			String input = scanner.nextLine();

			// Switch case for cleaner code.
			switch (input) {

			// Display account if successful
			// Otherwise go back to login menu
			case "1":

				// Check with login
				try {
					// Get username and password
					System.out.println("Username: ");
					String username = scanner.nextLine();
					System.out.println("Password: ");
					String password = scanner.nextLine();

					BankUsers bUser = userOps.login(username, password);

					if (bUser == null || bUser.getUserId() == 0) {
						throw new LoginNotValidException();
					}

					System.out.println("Login Successful!");

					// Proceed to account information if all is well.
					// Proceed to superuser if Roleid is 1
					if (bUser.getRoleId() == 1) {
						AccountSuperAccess(bUser, scanner);
						AccountAccess(bUser, scanner);
					} else {
						AccountAccess(bUser, scanner);
					}

				} catch (LoginNotValidException e) {
					System.out.println(e.getMessage());
				}

				break;

			// Register new user
			case "2":
				System.out.println("Username: ");
				String newuser = scanner.nextLine();
				System.out.println("Password: ");
				String newpass = scanner.nextLine();

				userOps.newUser(newuser, newpass);
				break;
			// Exit program.
			case "3":
				System.out.println("Exiting bank.");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid input\n");
				break;
			}

		}

		scanner.close();

	}

	// AccountAccess
	// Helper class created to organize code.
	// Check roleid
	// : if 1 : go to superuser account access mode
	// : if 2 : go to normal account access mode
	private static void AccountAccess(BankUsers bu, Scanner scanner) {
		boolean keepGoing = true;
		AccountOracle accountOps = new AccountOracle();

		while (keepGoing) {
			// Print out account info by default
			ArrayList<Accounts> accounts = accountOps.getAccounts(bu.getUserId());
			System.out.println(" ");
			for (Accounts acc : accounts) {
				acc.printAccount();
			}
			System.out.println("1 - Withdraw");
			System.out.println("2 - Deposit");
			System.out.println("3 - Create Account");
			System.out.println("4 - Delete Account");
			System.out.println("5 - Logout");
			try {
				String input = scanner.nextLine();
				switch (input) {

				case "1":
					System.out.println("Choose account number to withdraw from: ");
					Integer wAccount = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter amount to withdraw");
					Double wAmount = Double.parseDouble(scanner.nextLine());

					// Withdraw
					accountOps.withdraw(bu.getUserId(), wAccount, wAmount);
					break;

				case "2":
					System.out.println("Choose accountid to deposit into: ");
					Integer dAccount = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter amount to deposit: ");
					Double dAmount = Double.parseDouble(scanner.nextLine());

					// Deposit
					accountOps.deposit(bu.getUserId(), dAccount, dAmount);
					break;

				case "3":
					System.out.println("Choose your account type:");
					System.out.println("1 - Checking");
					System.out.println("2 - Saving");

					// Create new account
					// Username must be unique
					try {
						int choice = Integer.parseInt(scanner.nextLine());
						accountOps.newAccount(bu.getUserId(), choice);
					} catch (NumberFormatException e) {
						System.out.println("Invalid account type id.");
					}

					break;

				case "4":
					System.out.println("Enter account ID to delete");
					int accountId = Integer.parseInt(scanner.nextLine());

					// Delete account
					// Account empty checking done within deleteAccount function
					accountOps.deleteAccount(bu.getUserId(), accountId);
					break;

				case "5":
					System.out.println("Logging out.");
					keepGoing = false;
					break;
				default:
					System.out.println("Invalid input.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input");
			}
		}

	}

	// Special access option for super users
	private static void AccountSuperAccess(BankUsers bu, Scanner scanner) {
		boolean keepGoing = true;
		UserOracle usr = new UserOracle();

		while (keepGoing) {
			try {
				System.out.println("1 - View All Users");
				System.out.println("2 - Create User");
				System.out.println("3 - Update User");
				System.out.println("4 - Delete User");
				System.out.println("5 - Logout");
				String input = scanner.nextLine();
				switch (input) {
				case "1":
					usr.showAllUsers();
					break;

				case "2":
					System.out.println("Please enter the following: ");
					System.out.println("Username: ");
					String username = scanner.nextLine();
					System.out.println("Password: ");
					String password = scanner.nextLine();

					// Create new user
					usr.newUser(username, password);

					break;
				case "3":
					System.out.println("Please enter the following: ");
					System.out.println("User ID:");
					int userid = Integer.parseInt(scanner.nextLine());
					System.out.println("Username:");
					String udUsername = scanner.nextLine();
					System.out.println("Password:");
					String udPassword = scanner.nextLine();
					System.out.println("Role ID (1 for super, 2 for normal):");
					int udRoleId = Integer.parseInt(scanner.nextLine());

					// Make sure self-edit doesn't happen
					if (userid == bu.getUserId()) {
						System.out.println("Cannot edit self");
					} else {
						// Update user information
						usr.editUser(userid, udRoleId, udUsername, udPassword);
					}
					break;

				case "4":
					System.out.println("Input the user id to be deleted.");
					int dUserId = Integer.parseInt(scanner.nextLine());
					// Make sure self deletion doesn't happen
					if (dUserId == bu.getUserId()) {
						System.out.println("Self deletion is prohibited.");
					} else {
						usr.deleteUser(dUserId);
					}

					break;
				case "5":
					System.out.println("Logging out.");
					keepGoing = false;
					break;

				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input");
			}
		}

	}

}
