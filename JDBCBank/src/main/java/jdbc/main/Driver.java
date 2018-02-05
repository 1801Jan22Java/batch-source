package jdbc.main;

import java.util.Scanner;

import jdbc.beans.Account;
import jdbc.dao.AccountDaoImpl;
import jdbc.dao.BankUserDaoImpl;
import jdbc.exceptions.InvalidPasswordException;
import jdbc.exceptions.InvalidUsernameException;

public class Driver {

	public static void main(String[] args) {
		BankUserDaoImpl b = new BankUserDaoImpl();
		CheckCrudentials c = new CheckCrudentials();
		Scanner s = new Scanner(System.in);
		boolean loggedOn = false;
		String username = "";
		String password = "";
		boolean validUser = false;
		boolean validPass = false;
		while (!loggedOn) {
			System.out.println("Welcome to JDBC Bank");
			System.out.println("Do you have an account?(y/n)");
			String yesNo = s.nextLine();

			if (yesNo.equals("y")) {
				System.out.println("please enter username");
				while (!validUser) {
					username = s.nextLine();
					if (username.length() > 0) {
						try {
							validUser = c.checkUsername(username);
						} catch (InvalidUsernameException e) {
							System.out.println(e.getMessage());
						}
					}
				}

				System.out.println("please enter password");
				while (!validPass) {
					password = s.nextLine();
					if (password.length() > 0) {
						try {
							validPass = c.checkPassword(username, password);
						} catch (InvalidPasswordException e) {
							System.out.println(e.getMessage());
						}
					}

				}
				// they have passed both validations, they are a real user
				loggedOn = true;
			}

			else if (yesNo.equals("n")) {
				System.out.println("would you like to create an account?(y/n)");
				String create = s.nextLine();

				switch (create) {

				case "y":
					System.out.println("please create a username");
					username = s.nextLine();
					System.out.println("please create a password");
					password = s.nextLine();
					b.addNewUser(username, password);
					loggedOn = true;
					break;

				case "n":
					System.out.println("have a nice day");
					s.close();
					System.exit(0);
				}
			}

			else {
				System.out.println("improper response. restarting...");
			}
		}
		
		while (loggedOn) {
			if (!b.isSuper(username, password)) {
				userOperation(username, password);
			} else {
				superOperation();
			}

		}
		s.close();
		System.exit(0);
	}

	public static void userOperation(String username, String password) {
		Scanner u = new Scanner(System.in);

		System.out.println("Please enter the number of your desired operation");
		System.out.println("0: create account\n" + "1: view accounts\n" + "2: delete account\n" + "3: deposit money\n"
				+ "4: withdraw money\n" + "5: logout");

		int choice = u.nextInt();
		u.nextLine();
		if (choice < 0 || choice > 5) {
			System.out.println("invalid operation number");
		}

		AccountDaoImpl adi = new AccountDaoImpl();
		BankUserDaoImpl bud = new BankUserDaoImpl();

		switch (choice) {

		case 0:
			// create an account for the specified user
			adi.createAccount(bud.getIdByUserAndPass(username, password));
			break;

		case 1:
			// create a view and display all accounts associated with that user
			System.out.println(adi.getAccountsByUserId(bud.getIdByUserAndPass(username, password)).toString());
			break;

		case 2:
			// delete specified account only if it is an account owned by them with no money
			System.out.println("enter the ID of the account you wish to delete");
			int acctId = u.nextInt();
			if (adi.getUserIdByAccountId(acctId)==bud.getIdByUserAndPass(username, password)) {
				adi.deleteAccount(acctId);
			} else {
				System.out.println("you don't own that account");
			}
			break;

		case 3:
			// deposit money into specified account
			System.out.println("enter the ID of the account you wish to deposit into");
			int id = u.nextInt();
			Account a = adi.getAccountById(id);
			if (a != null) {
				System.out.println("enter the amount to deposit");
				int amnt = u.nextInt();
				if (amnt > 0) {
					adi.deposit(id, amnt);
				} else {
					System.out.println("invalid deposit amount");
				}
			} else {
				System.out.println("that is not an account in our system");
			}
			break;

		case 4:
			// subtract amount from account if they have enough in account
			System.out.println("enter the ID of the account you wish to withdraw from");
			int accountId = u.nextInt();
			if (adi.getUserIdByAccountId(accountId)==bud.getIdByUserAndPass(username, password)) {
				System.out.println("enter the amount you wish to withdraw");
				int amount = u.nextInt();
				adi.withdraw(amount, accountId);
			} else {
				System.out.println("you don't own that account");
			}
			break;

		case 5:
			System.out.println("thanks for using JDBC Bank, have a nice day");
			u.close();
			System.exit(0);
		}
	}

	public static void superOperation() {

		Scanner sup = new Scanner(System.in);
		System.out.println("Please enter the number of your desired operation");
		System.out.println("0: view user\n" + "1: create user\n" + "2: update a username\n" + "3: update a password\n"
				+ "4: delete a user\n" + "5: logout");

		int choice = sup.nextInt();
		sup.nextLine();
		if (choice < 0 || choice > 5) {
			System.out.println("invalid operation number");
		}
		
		BankUserDaoImpl bud = new BankUserDaoImpl();

		switch (choice) {

		case 0:
			// view the specified user
			System.out.println("enter the userId of the account you want to view");
			int usrId=sup.nextInt();
			System.out.println(bud.viewUser(usrId).toString());
			break;

		case 1:
			// create a  user
			System.out.println("please create a username");
			String username = sup.nextLine();
			System.out.println("please create a password");
			String password = sup.nextLine();
			bud.addNewUser(username, password);
			break;

		case 2:
			// update specified username
			System.out.println("enter the userId whose username you wish to change");
			int i = sup.nextInt();
			sup.nextLine();
			System.out.println("enter the new username");
			String newName = sup.nextLine();
			if(i==bud.getIdByUserAndPass("admin", "admin")) {
				System.out.println("nice try");
			}
			else {
				bud.updateUsername(newName, i);
			}
			
			break;

		case 3:
			// update specified password
			System.out.println("enter the userId whose password you wish to change");
			int id = sup.nextInt();
			sup.nextLine();
			System.out.println("enter the new password");
			String newPass = sup.nextLine();
			if(id==bud.getIdByUserAndPass("admin", "admin")) {
				System.out.println("nice try");
			}
			else {
				bud.updatePassword(newPass, id);
			}
			break;

		case 4:
			// delete a user
			System.out.println("enter the ID of the user you wish to delete");
			int userId = sup.nextInt();
			if (userId==bud.getIdByUserAndPass("admin", "admin")) {
				System.out.println("I won't let you delete yourself!");
			}
			else {
				bud.deleteUser(userId);
			}
			break;

		case 5:
			System.out.println("goodbye administrator, i'll miss you!");
			sup.close();
			System.exit(0);
		}

	}
}
