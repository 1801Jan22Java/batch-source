package com.revature.JDBCBank;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.Scanner;

public class JDBCApplication {

	public static void main(String[] args) {

		// Instantiate classes here
		UserOracle user_ops = new UserOracle();
		AccountOracle account_ops = new AccountOracle();

		Scanner scanner = new Scanner(System.in);

		boolean keepGoing = true;

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
				System.out.println("Username: ");
				String username = scanner.nextLine();
				System.out.println("Password: ");
				String password = scanner.nextLine();
				Integer userid = user_ops.login(username, password);
				// If it returns 0, go back to login
				if (userid == 0) {
					System.out.println("Login Failed");
				} else {

				}

				break;

			// Register new user
			case "2":
				System.out.println("Username: ");
				String newuser = scanner.nextLine();
				System.out.println("Password: ");
				String newpass = scanner.nextLine();

				user_ops.newUser(newuser, newpass);
				System.out.println("New Account Created!");
				break;
			// Exit program.
			case "3":
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid input\n");
				break;
			}

		}
		scanner.close();
	}
}
