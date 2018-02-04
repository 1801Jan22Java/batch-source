package BankingProject.JDBC_Bank;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.dao.UserDaoImpl;

public class BankDriver {

	public static void main(String[] args) {

		UserDaoImpl UDI = new UserDaoImpl();
		ArrayList<User> usrs = UDI.getUsers();
		ArrayList<String> userNames = UDI.getUserNames(usrs);
		ArrayList<Credentials> credentialsList = UDI.getCredentials(usrs);
		// UDI.getUsers() talks to the DB, UDI.getUserNames() takes that list
		// and extracts the username Strings into another ArrayList.

		Integer choice = null;
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
				tempPassword0 = scanner.nextLine();
				System.out.print("Confirm password: \t");
				tempPassword1 = scanner.nextLine();
			} while (!tempPassword0.equals(tempPassword1));

			Credentials c = new Credentials(tempName, tempPassword0);
			
			int nextID = UDI.getNextUserID();
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
				System.out.println("First name: \t" + firstName);
				System.out.println("Last name: \t" + lastName);
				System.out.println("Birthday: " + birthday.toString());
				System.out.println("Email: \t" + email);
				System.out.print("Continue (Y/N)? \t");
				complete = (scanner.nextLine().toCharArray())[0];
				//"Yes", "Yep" "Yah", etc work for this
			} while ((complete == 'Y') || (complete == 'y'));

			User newUser = new User(nextID, c, firstName, lastName, birthday, email, today, active);
			UDI.addUser(newUser);
			complete = 'x';
			do {
				System.out.println("Account Created. Exit Bank of Doge (Y/N)?");
				complete = (scanner.nextLine().toCharArray())[0];
				if ((complete == 'Y') || (complete == 'y'))
					System.exit(0);

			} while ((complete != 'N') || (complete != 'n'));
		} // end registering new user account
		////////////////////////////////////////////////////////////////////////////////
		int currentUserID = 0;
		////////////////////////////////////////////////////////////////////////////////
		// User logging in
		String uname = null;
		String pass = null;
		boolean valid = false;
		do {
			valid = false;
			System.out.println("Please login with username and password");
			System.out.print("Username: \t");
			uname = scanner.nextLine();
			System.out.print("Password: \t");
			pass = scanner.nextLine();
			for(User u: usrs) {
				if(u.getUserName().equals(uname) && u.getPassword().equals(pass)) {
					valid = true;
					currentUserID = u.getUserID();
					break;
				}
			}
		} while (!valid);

		// end user login
		////////////////////////////////////////////////////////////////////////////////
		
		////////////////////////////////////////////////////////////////////////////////
		// User menu
		complete = 'a';
		do {
			
		} while ((complete != 'Y') && (complete != 'y'));
		
		
		// end user menu
		////////////////////////////////////////////////////////////////////////////////
	}

}
