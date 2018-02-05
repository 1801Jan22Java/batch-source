package main;

import java.util.ArrayList;
import java.util.Scanner;

import beans.Account;
import beans.User;
import beans.UserInfo;
import doa.AccountDAOImpl;
import doa.UserDAOImpl;
import doa.UserInfoDAOImpl;
import util.*;

public class BankManager {
	
	private User currentUser = null;
	private UserInfo currentUserInfo;
	private ArrayList<Account> currentAccounts;
	BankManager(String userName, String password) throws NoSuchUserNameAndPasswordException, NotEnoughMoneyException
	{
		UserDAOImpl userDAO = new UserDAOImpl();
		ArrayList<User> users = userDAO.getUsers();
		for(User u: users)
		{
			if(u.getUserName().equalsIgnoreCase(userName) && u.getPassword().equalsIgnoreCase(password))
			{
				currentUser=u;
				//System.out.println(u.toString());
			}
			
		}
		//System.out.println(this.currentUser);
		if(this.currentUser == null)
		{
			throw new NoSuchUserNameAndPasswordException();
		}
		else
		{
			this.login();
		}
	}
	public void login() throws NotEnoughMoneyException
	{
		UserInfoDAOImpl userInfoDao = new UserInfoDAOImpl();
		AccountDAOImpl userAccountDao = new AccountDAOImpl();
		this.currentUserInfo= userInfoDao.getUserinfoByUserID(this.currentUser.getUserId());
		this.currentAccounts = userAccountDao.getAccountsByUser(this.currentUser.getUserId());
		boolean cnt = true;
		Scanner input = new Scanner(System.in);
		while(cnt)
		{
			System.out.println("What would you like to do "+this.currentUserInfo.toString());
			System.out.println("1: View Accounts");
			System.out.println("2: Deposit/Withdraw");
			System.out.println("3: Create a new Savings or Checking account");
			System.out.println("4: Log out");
			System.out.println("5: Delete an Account");
			int choice = input.nextInt();
			switch(choice)
			{
				case 1:
					for(Account a: this.currentAccounts)
					{
						String actType = "";
						if(a.getAccountType()==0)
							actType = "Checking";
						else
							actType = "Savings";
						System.out.println(actType+" "+a.getAccountid()+"\t"+a.getBalance());
					}
					break;
				case 2:
					System.out.println("Which account would you like to access?(by account id)");
					int actid = input.nextInt();
					Account ac = null;
					for(Account a: this.currentAccounts) 
					{
						if(a.getAccountid()==actid)
						{
							ac = a;
						}
					}
					if(ac == null)
					{
						System.out.println("Invalid Choice");
						break;
					}
					System.out.println("Would you like to make a depsoit or a withdrawl?(1 or 2)");
					int wod = input.nextInt();
					System.out.println("How much would you like?");
					float ch = input.nextFloat();
					depositWithdrawl(ac, ch, wod);
					break;
				case 3:
					System.out.println("What type of account would you like?");
					System.out.println("0: Checkings");
					System.out.println("1: Savings");
					int actType = input.nextInt();
					if(actType >1)
					{
						System.out.println("Invalid Option");
						break;
					}
					System.out.println();
					userAccountDao.createAccount(0, this.currentUser.getUserId(), actType, 0f);
					this.currentAccounts = userAccountDao.getAccountsByUser(this.currentUser.getUserId());
					break;
				case 4:
					cnt = false;
					break;
				case 5:
					System.out.println("Which Account would you like to delete?(By account Id");
					int actId = input.nextInt();
					userAccountDao.removeAccount(actId);
					this.currentAccounts = userAccountDao.getAccountsByUser(this.currentUser.getUserId());
					break;
			}
			
		}
	}
	private void depositWithdrawl(Account a, float change, int wod) throws NotEnoughMoneyException
	{
		AccountDAOImpl userAccountDao = new AccountDAOImpl();
		switch(wod)
		{
			case 1:
				userAccountDao.updateAccount(change, a);
				break;
			case 2:
				userAccountDao.updateAccount(-change, a);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
		}
	}

}
