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
		AccountDaoImpl ADI = new AccountDaoImpl();
		ArrayList<User> usrs = UDI.getUsers();
		ArrayList<String> userNames = UDI.getUserNames(usrs);
		User tempU = null;
		// UDI.getUsers() talks to the DB, UDI.getUserNames() takes that list
		// and extracts the username Strings into another ArrayList.

		Integer choice = 3;
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
				
				System.out.println("\n================================");
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
			tempU = newUser;
			ADI.setCurrentUser(tempU);
			usrs = UDI.getUsers();
		} // end registering new user account
			////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////
		// User logging in
		String uname = null;
		String pass = null;
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

			
			tempU = UDI.getUserByUsername(uname);
			if(tempU != null) {
				ADI.setCurrentUser(tempU);
				valid = true;
			}
			else {
				System.out.println("NULL ISSUE 141");
				System.out.println("Incorrect Username or Password");
				valid = false;
			}
			
		} while (!valid);

		// end user login
		////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////
		// User menu
		complete = 'a';
		choice = 0;
		if(tempU == null)
			System.out.println("NULL ISSUE 152");
		if (!isSuper) {
			ADI.setCurrentUser(tempU);
			if(ADI.getCurrentUser() == null)
				System.out.println("NULL ISSUE 156");
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
					System.out.println("==========================");
					for (Account a : ADI.ADI_Accounts) {
						if(a != null)
							a.toString();
					}
					System.out.println("==========================");
					break;
				}

				case 2: {
					String temp;
					String tempType;
					System.out.println("To add account, please specify the following");
					System.out.print("Account name: \t");
					temp = scanner.next();
					System.out.println();
					System.out.print("Account type: \t");
					tempType = scanner.next();
					Account tempA = new Account(tempType, 0.0, 0.0, LocalDate.now(), temp);
					ADI.addAccount(tempA);
					System.out.println("Account Created.");
					
					break;
				}
				case 3: {
					String name;
					System.out.print("Enter Name of Account to Delete: \t");
					name = scanner.nextLine();
					ArrayList<Account> acc = ADI.getAccounts();
					for (Account a : acc) {
						if (a.getAccountName().equals(name)) {
							try {
								ADI.deleteAccount(a);
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
					ArrayList<Account> a = ADI.getAccounts();
					for (Account acc : a) {
						System.out.println("================================================");
						System.out.println(acc.getAccountName() + ": ");
						for (Transaction t : acc.getTransactions()) {
							t.toString();
						}
					}
				}

				case 5: {
					Account toTransact = null;
					System.out.print("Add a new transaction - Specify account name: \t");
					String name = scanner.next();
					for (Account a : ADI.getAccounts()) {
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
					System.out.print("Would you like to exit (Y/N)?\t");
					complete = scanner.next().trim().charAt(0);
				}
				}
				System.out.print("Would you like to exit (Y/N)?\t");
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
						uname = scanner.next().trim();
						System.out.print("Password: \t");
						pass = scanner.next().trim();

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
						firstName = scanner.next();
						System.out.print("Last Name: \t");
						lastName = scanner.next();
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
						complete = scanner.next().trim().charAt(0);
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
						tempUser = UDI.getUserByUsername(name);
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
						tempUser = UDI.getUserByUsername(tempStr);
						String firstName = null;
						String lastName = null;
						int year;
						int month;
						int day;
						LocalDate birthday = null;
						String email = null;
						do {
							System.out.print("First name: \t");
							firstName = scanner.next();
							System.out.print("Last Name: \t");
							lastName = scanner.next();
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
							complete = scanner.next().trim().charAt(0);
						} while ((complete == 'Y') || (complete == 'y'));
					} else {
						throw new RuntimeException();
					}
					break;
				} // end case 4
				case 5: {
					System.out.println("Pressing the big red button.");
					System.out.println("Deleting all users");
					usrs = UDI.getUsers();
					for (User u : usrs) {
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
