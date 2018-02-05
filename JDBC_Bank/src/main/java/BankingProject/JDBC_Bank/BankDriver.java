package BankingProject.JDBC_Bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.SuperUser;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.util.AccountNotEmptyException;
import com.revature.util.InvalidAccountIdException;

public class BankDriver {

	public static void main(String[] args) {

		UserDaoImpl UDI = new UserDaoImpl();
		ArrayList<User> usrs = UDI.getUsers();
		ArrayList<String> userNames = UDI.getUserNames(usrs);
		// UDI.getUsers() talks to the DB, UDI.getUserNames() takes that list
		// and extracts the username Strings into another ArrayList.

		Integer choice = null;
		Boolean isSuper = false;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the First Bank of Doge");
		System.out.println("Please either login with an existing account (0)");
		System.out.println("\t or register a new account (1)");
		do {
			System.out.print("Enter your choice: \t");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("That is not a proper number.");
				continue;
			}
		} while ((choice != 0) && (choice != 1));

		Character complete = 'X';
		////////////////////////////////////////////////////////////////////////////////////
		// Registering new User account
		if (choice == 1) {
			String tempName = new String();
			boolean taken = false;
			do {
				System.out.print("Choose a username for the account: \t");
				tempName = scanner.nextLine();
				if (userNames.contains(tempName)) {
					System.out.println("Username already taken.");
					taken = true;
				} else
					taken = false;
			} while (taken);

			String tempPassword0 = "Zero";
			String tempPassword1 = "One";
			// two different String references for "confirm password" functionality

			do {
				System.out.print("Enter in the password for the account: \t");
				tempPassword0 = scanner.nextLine().trim();
				System.out.print("Confirm password: \t");
				tempPassword1 = scanner.nextLine().trim();
			} while (!tempPassword0.equals(tempPassword1));

			String firstName = null;
			String lastName = null;
			Integer year = 0;
			Integer month = 0;
			Integer day = 0;
			LocalDate birthday = null;
			String email = null;
			int active = 1; // positive numbers imply active user
			LocalDate today = LocalDate.now();
			do {
				System.out.print("First name: \t");
				firstName = scanner.nextLine();
				System.out.print("Last Name: \t");
				lastName = scanner.nextLine();
				System.out.print("Birth Year: \t");
				year = scanner.nextInt();
				System.out.print("Birth Month (number): \t");
				month = scanner.nextInt();
				System.out.print("Birth Day: \t");
				day = scanner.nextInt();
				birthday = LocalDate.of(year, month, day);
				System.out.print("Email: \t");
				email = scanner.next();

				System.out.println("User info: ");
				System.out.println("First name: \t" + firstName);
				System.out.println("Last name: \t" + lastName);
				System.out.println("Birthday: " + birthday.toString());
				System.out.println("Email: \t" + email);
				System.out.print("Continue (Y/N)? \t");
				complete = scanner.next().trim().charAt(0);
				System.out.println();
				System.out.println("++++++++++++++++++++++++++++++++++++++");
				// "Yes", "Yep" "Yah", etc work for this
			} while ((complete != 'Y') && (complete != 'y'));

			User newUser = new User(tempName, tempPassword0, firstName, lastName, birthday, email, today, active);
			UDI.addUser(newUser);
			usrs = UDI.getUsers();
		} // end registering new user account
			////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////
		// User logging in
		String uname = null;
		String pass = null;
		User tempU = null;
		boolean valid = false;
		do {
			valid = false;
			System.out.println("Please login with username and password");
			System.out.print("Username: \t");
			uname = scanner.next();
			System.out.print("Password: \t");
			pass = scanner.next();

			if (SuperUser.rootLogin(uname, pass))
				isSuper = true;

			if (UDI.contains(usrs, uname)) {
				valid = true;
				tempU = UDI.getUserByUsername(usrs, uname);
				break;
			}
			System.out.println("Incorrect Username or Password");

		} while (!valid);

		// end user login
		////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////
		// User menu
		complete = 'a';
		choice = 0;
		if (!isSuper) {
			do {

				System.out.println("Please choose an option:");
				System.out.println("1 - View all your accounts");
				System.out.println("2 - Create a new account");
				System.out.println("3 - Delete an Account");
				System.out.println("4 - View all transactions");
				System.out.println("5 - Make a new transaction");
				System.out.println("6 - Logout");
				System.out.print("Make a choice: \t");
				choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					AccountDaoImpl ADI1 = new AccountDaoImpl();
					for (User u : usrs) {
						if (u.getUserID() == tempU.getUserID()) {
							System.out.println("Showing user accounts");
							ArrayList<Account> accs = ADI1.getAccounts(u);
							for (Account a : accs) {
								a.toString();
							}
						}
					}
					break;
				}

				case 2: {
					AccountDaoImpl ADI2 = new AccountDaoImpl();
					String temp;
					String tempType;
					System.out.println("To add account, please specify the following");
					System.out.print("Account name: \t");
					temp = scanner.next();
					System.out.print("Account type: \t");
					tempType = scanner.next();
					boolean uniqueName = true;
					for (Account a : ADI2.getAccounts(tempU)) {
						if (a.getAccountName().equals(temp)) {
							System.out.println("Account name already in use");
							uniqueName = false;
						}
					}
					if (uniqueName) {
						Account tempA = new Account(tempType, 0.0, 0.0, LocalDate.now(), temp);
						ADI2.addAccount(tempA, tempU);
						System.out.println("Account Created.");
					}
					break;
				}
				case 3: {
					String name;
					System.out.print("Enter Name of Account to Delete: \t");
					name = scanner.nextLine();
					AccountDaoImpl ADI3 = new AccountDaoImpl();
					for (Account a : ADI3.getAccounts(tempU)) {
						if (a.getAccountName().equals(name)) {
							try {
								ADI3.deleteAccount(a);
							} catch (InvalidAccountIdException e) {
								System.out.println("Account named doesn't exist");
							} catch (AccountNotEmptyException e) {
								System.out.println("Account is not empty, cannot delete");
							}
						}
					}
				}
				case 4: {
					System.out.println("Showing All transactions");
					AccountDaoImpl ADI4 = new AccountDaoImpl();
					for (Account a : ADI4.getAccounts(tempU)) {
						System.out.println("================================================");
						System.out.println(a.getAccountName() + ": ");
						for (Transaction t : a.getTransactions()) {
							t.toString();
						}
					}
				}

				case 5: {
					AccountDaoImpl ADI5 = new AccountDaoImpl();
					Account toTransact = null;
					System.out.print("Add a new transaction - Specify account name: \t");
					String name = scanner.nextLine();
					for (Account a : ADI5.getAccounts(tempU)) {
						if (a.getAccountName().equals(name)) {
							toTransact = a;
						}
					}
					System.out.println(toTransact.toString());
					System.out.print("Enter deposit (positive) or withdraw (negative): \t");
					Double amount = scanner.nextDouble();
					TransactionDaoImpl TDI = new TransactionDaoImpl();
					Transaction t = new Transaction(LocalDate.now(), amount);
					TDI.addTransaction(t, toTransact);
					System.out.println("Transaction Complete");
				}
				case 6: {
					System.out.println("Logging out. Thank you for using the First Bank of Doge");
					complete = 'Y';
					break;
				}

				default: {
					System.out.print("Would you like to exit (Y/N)?\t\t");
					complete = (scanner.nextLine().toCharArray())[0];
				}
				}
				System.out.print("Would you like to exit (Y/N)?\t\t");
				complete = scanner.next().trim().charAt(0);
			} while ((complete != 'Y') && (complete != 'y'));
		}

		else {
			do {
				System.out.println("Welcome Superuser. Please choose an option");
				System.out.println("1 - Create a User");
				System.out.println("2 - View a User");
				System.out.println("3 - View All Users");
				System.out.println("4 - Update a User");
				System.out.println("5 - Nuke System - Delete All Users (excluding Superuser)");

				switch (choice) {
				case 1: {
					do {
						valid = true;
						System.out.println("Please Enter username and password");
						System.out.print("Username: \t");
						uname = scanner.nextLine().trim();
						System.out.print("Password: \t");
						pass = scanner.nextLine().trim();

						for (User u : usrs) {
							if (u.getUserName().equals(uname)) {
								valid = false;
								tempU = u;
								break;
							}
							System.out.println("Username already taken");
						}
					} while (!valid);
					String firstName = null;
					String lastName = null;
					Integer year = 0;
					Integer month = 0;
					Integer day = 0;
					LocalDate birthday = null;
					String email = null;
					int active = 1; // positive numbers imply active user
					LocalDate today = LocalDate.now();
					do {
						System.out.print("First name: \t");
						firstName = scanner.nextLine();
						System.out.print("Last Name: \t");
						lastName = scanner.nextLine();
						System.out.print("Birth Year: \t");
						year = scanner.nextInt();
						System.out.print("Birth Month (number): \t");
						month = scanner.nextInt();
						System.out.print("Birth Day: \t");
						day = scanner.nextInt();
						birthday = LocalDate.of(year, month, day);
						System.out.print("Email: \t");
						email = scanner.nextLine();

						System.out.println("User info: ");
						System.out.println("Username: \t" + uname);
						System.out.println("First name: \t" + firstName);
						System.out.println("Last name: \t" + lastName);
						System.out.println("Birthday: " + birthday.toString());
						System.out.println("Email: \t" + email);
						System.out.print("Continue (Y/N)? \t");
						complete = (scanner.nextLine().toCharArray())[0];
					} while ((complete == 'Y') || (complete == 'y'));

					User newUser = new User(uname, pass, firstName, lastName, birthday, email, today, active);
					UDI.addUser(newUser);
					usrs = UDI.getUsers();
					break;
				} // end case 1
				case 2: {
					System.out.print("Enter in the username to view: \t");
					String name = scanner.next();
					usrs = UDI.getUsers();
					User tempUser = null;
					if (!UDI.contains(usrs, name)) {
						System.out.println("Username not found");
					} else {
						tempUser = UDI.getUserByUsername(usrs, name);
						tempUser.toString();
					}
					break;
				} // end case 2
				case 3: {
					usrs = UDI.getUsers();
					for (User u : usrs) {
						System.out.println(u.toString());
						System.out.println("----------------------------");
					}
					break;
				} // end case 3
				case 4: {
					System.out.println("Enter username to update: ");
					String tempStr = scanner.next();
					User tempUser = null;
					if (usrs.contains(tempStr)) {
						tempUser = UDI.getUserByUsername(usrs, tempStr);
						String firstName = null;
						String lastName = null;
						int year;
						int month;
						int day;
						LocalDate birthday = null;
						String email = null;
						do {
							System.out.print("First name: \t");
							firstName = scanner.nextLine();
							System.out.print("Last Name: \t");
							lastName = scanner.nextLine();
							System.out.print("Birth Year: \t");
							year = scanner.nextInt();
							System.out.print("Birth Month (number): \t");
							month = scanner.nextInt();
							System.out.print("Birth Day: \t");
							day = scanner.nextInt();
							birthday = LocalDate.of(year, month, day);
							System.out.print("Email: \t");
							email = scanner.nextLine();

							System.out.println("User info: ");
							System.out.println("First name: \t" + firstName);
							System.out.println("Last name: \t" + lastName);
							System.out.println("Birthday: " + birthday.toString());
							System.out.println("Email: \t" + email);
							System.out.print("Continue (Y/N)? \t");
							complete = (scanner.nextLine().toCharArray())[0];
						} while ((complete == 'Y') || (complete == 'y'));
					}
					else {
						throw new RuntimeException();
					}
					break;
				} // end case 4
				case 5: {
					System.out.println("Pressing the big red button.");
					System.out.println("Deleting all users");
					usrs = UDI.getUsers();
					for(User u: usrs) {
						UDI.deleteUser(u);
					}
					break;
				} // end case 5
				}
				System.out.println("Continue (Y/N)?\t");
				complete = scanner.next().trim().charAt(0);
			} while ((complete != 'Y') && (complete != 'y'));
			SuperUser.rootLogout();
			isSuper = false;
		}

		// end user menu
		////////////////////////////////////////////////////////////////////////////////

		scanner.close();
	}

}
