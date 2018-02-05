package main;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import doa.*;
import util.ConnectionUtil;



public class Driver {

	public static void main(String[] args) throws ParseException
	{
		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);
		Scanner input = new Scanner(System.in);
		UserDAOImpl userdao = new UserDAOImpl();
		AccountDAOImpl actdao = new AccountDAOImpl();
		//System.out.println(userdao.getUsers().toString());
		//userdao.registerNewUser("kitty222", "wordPass1", "Hello", "Kitty", "Of Mind", "the moment", date, "867 Japan ave.", "000001");
		//actdao.createAccount(0, 1024, "Savings", 0f, date, 0);
		//System.out.println(actdao.getAccounts().toString());
		System.out.println("Welcome! How may I assist you?");
		System.out.println("1: Login in");
		System.out.println("2: Register a New Account");
		System.out.println("3: Login as a Super User");
		int choice = input.nextInt();
		boolean cnt = true;
		while(cnt)
		{
			switch(choice)
			{
				case 1:
					
					break;
				case 2:
					System.out.print("Enter your User Name: ");
					String userName = input.next();
					System.out.print("Enter your Password: ");
					String password = input.next();
					System.out.print("Enter your First Name: ");
					String firstName = input.next();
					System.out.print("Enter your Last Name: ");
					String lastName = input.next();
					System.out.print("Enter your  State: ");
					String state = input.next();
					System.out.print("Enter your  Zipcode: ");
					String zip = input.next();
					System.out.print("Enter your  Birthdate!(MM/DD/YYYY): ");
					String bDay = input.next();
					System.out.print("Enter your  Address: ");
					String address = input.nextLine();
					System.out.print("Enter your  Social Security Number: ");
					String ssn = input.next();
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					java.sql.Date sqlDate = new java.sql.Date(df.parse(bDay).getTime());
					userdao.registerNewUser(userName, password, firstName, lastName, state, zip, sqlDate, address, ssn);
					break;
				case 3:
					
					break;
			}
			System.out.println("Continue? Y/N");
			if(input.next().equalsIgnoreCase("N"))
				cnt = false;
				input.close();
		}
		
	}
}
