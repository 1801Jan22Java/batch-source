package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.Exceptions.InvalidCredentialsException;
import com.revature.Exceptions.OverdraftException;
import com.revature.Exceptions.ZeroBalanceException;
import com.revature.beans.Account;
import com.revature.beans.CheckingAccount;
import com.revature.beans.SavingsAccount;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{
	private static String filename = "connection.properties";
	
	public Account getAccountById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * validateAmount() takes in string input returns a boolean valid 
	 * more precisely, it ensures that the user entered a non-zero positive number,
	 * and not a negative number or a string of characters.  if the user enters a negative number or zero, the
	 * method complains.  If the user enters a string, it enters a NumberFormatException and returns false
	 * otherwise, validateAmount() returns true
	 * @param String input
	 * @return boolean valid
	 * */
	private boolean validateAmount(String input)
	{
		boolean valid =false;
		try{

			float result =Float.parseFloat(input);
			if(result<0)
			{
				System.out.println("The number you entered was invalid");
			}
			else{ 
				valid=true;}
		}
		catch(NumberFormatException e)
		{
			System.out.println("The number you entered was invalid");
		}
		finally{
			return valid;
		}
	}

	/*
	 * Takes in a string input and returns a float, after calling validateAmount() on the string input.
	 * if validateAmount returns true, convertToFloat returns a non-zero amount.  
	 * Otherwise, convertToFloat returns zero.
	 * @param String input
	 * @return float result
	 * */
	private float convertToFloat(String input)
	{
		float result = 0.0f;
		if(validateAmount(input)){
			result =Float.parseFloat(input);
		}
		else
		{
			result= 0.0f;
		}
		return result;
	}
	/*
	 * addAccount adds a new account for a user.
	 * takes in an Account object and a User object.
	 * First creates an account
	 * */
	@Override
	public void addAccount(Account account,User user)
	{

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			UserDaoImpl udi = new UserDaoImpl();
			conn.setAutoCommit(false);
	//		System.out.println("In try statement"); //DEBUGGING
			String sqlStmt="{CALL SP_NEW_ACCOUNT(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sqlStmt);
			cs.setInt(1,account.getAccountType().getAccountTypeID());
			cs.setFloat(2,account.getBalance());
			cs.setInt(3,udi.getUserID(user));
			cs.execute();
			conn.commit();
			System.out.println("Account for user " + udi.getUserID(user)+ " created with a balance of " + account.getBalance());
		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void deposit(int accountID, float amount, User user) {

		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to make a withdrawal");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for deposit");
				String sqlStmt="{CALL SP_MAKE_DEPOSIT(?,?)}";
				CallableStatement cs = conn.prepareCall(sqlStmt);
				cs.setInt(1,accountID);
				cs.setFloat(2,amount);
				cs.execute();
				conn.commit();
				showBalance(user,accountID);
			}
		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}
	public boolean validateAccount(User user, int accountID)
	{
		boolean accountValid=false;
		try(Connection conn=ConnectionUtil.getConnectionFromFile(filename))
		{
			UserDaoImpl upi=new UserDaoImpl();
			if(upi.validateCredentials(user.getUserName(),user.getPassword()))
			{
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ? AND USER_ID IN("
						+ "SELECT USER_ID FROM USERS WHERE USER_NAME=? AND USER_PASS=?)");
				ps.setInt(1, accountID);
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getPassword());
				ps.execute();
				ResultSet rs = ps.getResultSet();
				if (rs.next())
				{
					//System.out.println("ACCOUNT!!");
					//System.out.println(rs.getInt("ACCOUNT_ID"));
					accountValid=true;
				}
				else
				{
					try {
						throw new InvalidCredentialsException("Those credentials are invalid.  Please try again.");
					} catch (InvalidCredentialsException e) {
						e.printStackTrace();
					}
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return accountValid;
	}

	@Override
	public void withdrawal(User user,int accountID, float amount) throws OverdraftException  {
		float currentBalance=0.0f;
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to make a withdrawal");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for withdrawal");
				String sqlStmt="{CALL SP_MAKE_WITHDRAWAL(?,?)}";
				PreparedStatement ps = conn.prepareStatement("SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID=?");
				ps.setInt(1, accountID);
				ps.execute();
				ResultSet rs = ps.getResultSet();
				if(rs.next())
				{
					currentBalance = rs.getFloat("BALANCE");
				}
				if(currentBalance<amount)
				{
					throw new OverdraftException("You may not withdraw more than what is in the account");
				}
				CallableStatement cs = conn.prepareCall(sqlStmt);
				cs.setInt(1,accountID);
				cs.setFloat(2,amount);

				cs.execute();
				conn.commit();
				showBalance(user,accountID);
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}


	@Override
	public Account getAccountById() {
		// TODO Auto-generated method stub
		return null;
	}

	public void showMenu(User user)
	{
		UserDaoImpl udi = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		if(udi.validateSuperUser(user)){
			System.out.println("Please make a selection:\n1: View balance "
					+ "\n2: Make deposit\n3: Make withdrawal\n4:Close account."
					+ "\n5: Create account.\n6: Delete user\n7: Create user\n8: Show Transactions. \n9: Show Accounts. \n10: Log out");
		}
		else
		{
			System.out.println("Please make a selection:\n1: View balance "
					+ "\n2: Make deposit\n3: Make withdrawal\n4:Close account."
					+ "\n5: Create account.\n8: Show Transactions. \n9: Show Accounts \n10: Log out");
		}
		try{
			int newOption = sc.nextInt();
			selectAction(newOption, user);	
		}
		catch(NumberFormatException e)
		{
			System.out.println("You must input a number value");
			e.printStackTrace();
		}

	}
	/*
	 * selectAction method takes in an integer and a user, and calls different methods based
	 * on user input.  Always calls the showMenu method unless the user opts to log out of the application.
	 * Throws OverdraftException, ZeroBalanceException, and InputMismatchException.
	 * */
	@Override
	public void selectAction(int option, User user) {
		UserDaoImpl udi = new UserDaoImpl(); 
		Scanner sc = new Scanner(System.in);
		try{
			switch(option)
			{
			case 1: 
				System.out.println("Please enter the account ID."); 
				int accountID = sc.nextInt(); 
				showBalance(user,accountID); 
				showMenu(user);
				break;
			case 2: 
				System.out.println("Please enter the account ID."); 
				accountID = sc.nextInt(); 
				System.out.println("Please choose an amount to deposit.");
				String amountStr =sc.next();
				boolean valid = validateAmount(amountStr);
				while(!valid)
				{
					System.out.println("You entered an invalid value.  Please try again");
					amountStr =sc.next();
					valid = validateAmount(amountStr);
				}
				float amount = convertToFloat(amountStr);
				deposit(accountID,amount,user); 
				showMenu(user);

				break;
			case 3 :System.out.println("Please enter the account ID."); 
			accountID = sc.nextInt(); 
			System.out.println("Please choose an amount to withdraw.");
			amountStr =sc.next();
			valid= validateAmount(amountStr);
			while(!valid){
				System.out.println("You entered an invalid value.  Please try again");
				amountStr =sc.next();
				valid = validateAmount(amountStr);
			}
				amount = convertToFloat(amountStr);
				try{
					withdrawal(user,accountID,amount); }
				catch(OverdraftException e)
				{
					e.printStackTrace();
				}
				finally{
					showMenu(user);
					break;
				}	
			case 4: System.out.println("Please enter the account ID to close");
			accountID=sc.nextInt();
			closeAccount(user,accountID);
			showMenu(user);
			break;
			case 5:System.out.println("Would you like a checking or a savings account?  "
					+ "Enter 1 for a savings account.  Enter 2 for a checking account");

			int userID = udi.getUserID(user);
			int choice =sc.nextInt();
			System.out.println("Please enter your initial balance");
			float initbal=sc.nextFloat();
			Account account =null;
			try{
				if(initbal==0){ 
					throw new ZeroBalanceException("Your initial balance must be greater than zero");
				}
				else{
					switch(choice){
					case 1: 


						account = new SavingsAccount(initbal,userID) ;
						addAccount(account,user); break;



					case 2:
						account = new CheckingAccount(initbal,userID) ;
						addAccount(account,user); break;
					}
				}
			}
			catch(ZeroBalanceException e){
				e.printStackTrace();
			}
			finally{
				showMenu(user);
				break;
			}
			case 6: 
				System.out.println("Please enter the user ID of the user you want to delete");
				userID=sc.nextInt();
				User user2 = udi.getUserById(userID);
				System.out.println("User attempting the deletion");
				System.out.println(udi.getUserID(user));
			 
				udi.deleteUser(user, user2);
				showMenu(user);
				break;
			case 7:
				udi.addUser(user);
				showMenu(user); 
				break;
			case 8: 
				System.out.println("Please enter your user ID");
				userID=sc.nextInt();
				user =udi.getUserById(userID);
				System.out.println("Please enter your account ID");
				accountID = sc.nextInt();
				showTransactions(user,accountID);
				showMenu(user);
				break;
			case 9: showUserAccounts(user); showMenu(user);
			break;
			case 10: user=udi.logout();
			break;
			default: 
				System.out.println("Invalid choice");
				showMenu(user);
			}
		}
		catch( InputMismatchException e)
		{
			System.out.println("That choice is invalid.  Please select a number from the options listed.");
			showMenu(user);
		}
	}

	
	public void showTransactions(User user, int accountID)
	{
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to see account information");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for showing balance");
				String sqlStmt="SELECT * FROM ACCOUNT_TRANSACTION WHERE ACCOUNT_ID=? ORDER BY DATE_OF_TRANSACTION DESC";
				PreparedStatement ps = conn.prepareStatement(sqlStmt);
				ps.setInt(1,accountID);
				ps.execute();
				ResultSet rs =ps.getResultSet();
				while(rs.next())
				{
					DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
					Date date =rs.getDate("DATE_OF_TRANSACTION");
					String dateStr=df.format(date);
					NumberFormat fmt = NumberFormat.getCurrencyInstance();
					Float amountChanged = rs.getFloat("AMOUNT_CHANGED");
					String description = rs.getString("TRANSACTION_DESC");
					String wholeLine = description + " of " +fmt.format(amountChanged)+  " on " + dateStr;
				
					System.out.println(wholeLine);
				}
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public void showBalance(User user, int accountID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to see account information");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for showing balance");
				String sqlStmt="SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID=?";
				PreparedStatement ps = conn.prepareStatement(sqlStmt);
				ps.setInt(1,accountID);
				ps.execute();
				ResultSet rs =ps.getResultSet();
				while(rs.next())
				{
					float balance =rs.getFloat("BALANCE");
					System.out.println("Your balance is: "+balance);
				}
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void closeAccount(User user, int accountID) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{

			if(!validateAccount(user,accountID))
			{
				System.out.println("You must be logged in to see account information");
			}
			else{
				conn.setAutoCommit(false);
				System.out.println("In try statement for showing balance");
				String sqlStmt="SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID=?";
				PreparedStatement ps = conn.prepareStatement(sqlStmt);
				ps.setInt(1,accountID);
				ps.execute();
				ResultSet rs =ps.getResultSet();
				while(rs.next())
				{
					float balance =rs.getFloat("BALANCE");
					if(balance>0)
					{
						System.out.println("You may not delete an account that has a balance");
					}
					else
					{
						CallableStatement cs = conn.prepareCall("{CALL SP_DELETE_ACCOUNT(?)}");
						cs.setInt(1, accountID);
						cs.execute();
					}
				}
			}

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}



	}

	public void showUserAccounts(User user)
	{
		try(Connection conn= ConnectionUtil.getConnectionFromFile(filename))
		{
			String sqlStatement = "SELECT * FROM ACCOUNTS WHERE USER_ID =?";
			UserDaoImpl udi = new UserDaoImpl();
			int userID =udi.getUserID(user);
			PreparedStatement ps = conn.prepareStatement(sqlStatement);
			ps.setInt(1, userID);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next())
			{
				int accountID = rs.getInt("ACCOUNT_ID");
				float balance = rs.getFloat("BALANCE");
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String acctInfo = "USER " + userID + " has account " + accountID 
						+" which has a balance of " + nf.format(balance);
				System.out.println(acctInfo);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
