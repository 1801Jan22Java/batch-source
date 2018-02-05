package com.revature.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;
import com.revature.exception.NotExistUserException;
import com.revature.logging.LoggingClass;
import com.revature.vo.BankAccountVo;
import com.revature.vo.BankUserVo;

public class MainController {

	public static Scanner sc = new Scanner(System.in);
	
	public static BankUserDao userDao = new BankUserDaoImpl();
	public static BankAccountDao accountDao = new BankAccountDaoImpl();
	public static BankUserVo userVo = new BankUserVo();
	public static LoggingClass lc = new LoggingClass();
	
	public static String userName;
	public static String password;
	public static String option;
	
	public static void main(String[] args) {
		
		String[] info;
		
		BasicConfigurator.configure();		// it configures log4j 		
		LoggingClass lc = new LoggingClass();
		
		System.out.println("Welcome to JDBC Bank!");
		boolean ifLoginSuccess = true;
		
		do {
			info = getInfo();
			userName = info[0];
			password = info[1];
			ifLoginSuccess = login(userName, password);	
			
		} while (!ifLoginSuccess);		// true - login success  / false - login fail, re-try!
		
		lc.logInfo(userName + ", welcome! login success!");
		userVo = userDao.getBankUserByName(userName);
		lc.logDebug(userVo.toString());
		
		
		// while login, always comes back to the account information display.
		boolean ifStayInlogin = true;
		while(ifStayInlogin) {
			
			// lv  0:superuser  1:basicuser	 (only superuser can see the user management menu)
			// check if has account.
			int accountCnt = accountDao.checkIfBankAccountExistByUserId(userVo.getId());
			
			if (accountCnt > 0) {
				// if account exist, display account info and provide option.
				List<BankAccountVo> accountVoList = accountDao.getBankByUserId(userVo.getId());
				
				lc.logInfo(userVo.getName() +"'s Account Status : ---------------");
				ArrayList<Integer> accountNos = new ArrayList<Integer>();
				
				for (BankAccountVo vo : accountVoList) {
					lc.logInfo("**** Account No. : " + vo.getId() + " / Total Balance : "+ vo.getBalance());
					accountNos.add(vo.getId());
				}
				
				if (userVo.lv == 0) {
					lc.logInfo("---- press 0 : manage users");
				}
				lc.logInfo("---- press 1 : create a new account");
				lc.logInfo("---- press 2 : make deposit");
				lc.logInfo("---- press 3 : withdrawal");
				lc.logInfo("---- press 4 : delete account");
				lc.logInfo("---- press 5 : log out");

				option = sc.nextLine().trim();
				
				switch(option) {
				case "0":									// create new account
					lc.logInfo("---- press 1 : view all users");
					lc.logInfo("---- press 2 : create users");
					lc.logInfo("---- press 3 : delete users"); 
					option = sc.nextLine().trim();
					
					switch(option) {
					case "1":
						// view all users
						break;
					case "2":
						// create users
						break;
					case "3":
						// delete users
						break;
					}
					break;
				case "1":									// create new account
					createNewBankAccount(userVo.getId());
					break;
				case "2":									// make deposit
					addDepositMoney(accountNos); 						
					break;
				case "3":									// withdraw
					minusDepositMoney(accountNos);
					break;
				case "4":
					
					break;
				case "5":
					logOut();					// initialize the user info 
					ifStayInlogin = false;
					break;
				default :
					lc.logInfo("wrong input. please try again.\r\n");
					break;
				}
				
				 
				
				
			} else {
				// if account not exist, create account and over.
				// if doesn't have account - 
				lc.logInfo("---- you have ZERO account.");
				if (userVo.lv == 0) {
					lc.logInfo("---- press 0 : manage users");
				}
				lc.logInfo("---- press 1 : create new account");
				lc.logInfo("---- press 2 : log out");
				
				option = sc.nextLine().trim();		
				
			    if (option.equals("0")){
			    	System.out.println("you chose Superuser menu!");
			    } else if (option.equals("1")) {					
					createNewBankAccount(userVo.getId());
					
				} else if (option.equals("2")) {
					logOut();					// initialize the user info 
					ifStayInlogin = false;
				}					
			}
		}
			
		 
		
		lc.logInfo("Bank Application is now turned off.");
	}
	
	
	// Bank App starts : get userName and password
	public static String[] getInfo() {
		System.out.println("Please enter user name");		
		userName = sc.nextLine().trim();	 
		
		System.out.println("Please enter password");
		password = sc.nextLine().trim();
		
		String[] info = {userName, password};

		return info;
	}
	
	// 1. check if user exist 	2. check if the password is right one
	public static Boolean login(String userName, String password)  {
		
		boolean ifLoginSucceed = true;
		if (userDao.ifUserExist(userName) < 1) {
			ifLoginSucceed = false;
		} else if (userDao.ifRightPW(userName, password) < 1) {
			ifLoginSucceed = false;
		} 
		return ifLoginSucceed; 
	}
	
	
	// create new bank account by userId
	public static void createNewBankAccount (int userId) {
		
			boolean ifRightOption = false;
			int initDeposit = 0;
			while(!ifRightOption) {
				lc.logInfo("please enter the initial deposit amount(starts from 0)");			
				try {
					initDeposit = Integer.parseInt(sc.nextLine());
					ifRightOption = true;
				} catch (NumberFormatException e) {
					lc.logInfo("please enter only number. Anything but number is not allowed.\r\n");
				}
			}
			accountDao.createBankAccount(initDeposit, userVo.getId());
			lc.logInfo("The new account is created.");

	}
	
	// add deposit 
	public static void addDepositMoney  (ArrayList<Integer> accountNos ) {
		int accountId = 0;
		boolean ifRightOption = false;

		while(!ifRightOption) {
			lc.logInfo("please choose the account you want to add money.");
			try {
				accountId = Integer.parseInt(sc.nextLine());
				ifRightOption = true;
			} catch (NumberFormatException e) {
				lc.logInfo("please enter only account number. Anything but number is not allowed.\r\n");
			}
		}
		
		if(!accountNos.contains(accountId)) {
			lc.logInfo("The account no "+ accountId +" doesn't exist. please choose from existing accounts.\r\n");
			return;
		}
		
		
		lc.logInfo("please enter the deposit amount (starts from 0)");
		int deposit = Integer.parseInt(sc.nextLine());
		accountDao.transactMoney("+", deposit, accountId);
		
		boolean stopAdd = true;
		while (stopAdd) {

			lc.logInfo("Would you like to add more money? ------- Y / N ");
			option = sc.nextLine();
			
			if (option.toUpperCase().equals("Y")) {
				lc.logInfo("please choose the account you want to add money.");
				accountId = Integer.parseInt(sc.nextLine());
				if(!accountNos.contains(accountId)) {
					lc.logInfo("wrong account information. please choose existing account.\r\n");
					return;
				}
				
				lc.logInfo("please enter the deposit amount (starts from 0)");
				deposit = Integer.parseInt(sc.nextLine());
				accountDao.transactMoney("+", deposit, accountId);

			} else if (option.toUpperCase().equals("N")) {
				stopAdd = false;
			} else {
				lc.logInfo("You press wrong button. please try again. \r\n");
			}
		}
		// transaction();		 // Connection's auto commit control doesn't work. 
	}

	// minus deposit  
	public static void minusDepositMoney(ArrayList<Integer> accountNos) {
		lc.logInfo("please choose the account you want to withdraw money.");
		int accountId = Integer.parseInt(sc.nextLine());

		if(!accountNos.contains(accountId)) {
			lc.logInfo("wrong account information. please choose existing account.\r\n");
			return;
		}
		
		lc.logInfo("please enter the withdrawal amount (starts from 0)");
		int deposit = Integer.parseInt(sc.nextLine());
		accountDao.transactMoney("-", deposit, accountId);
		 
			
		boolean stopWithdraw = false;
		while(!stopWithdraw) {
			lc.logInfo("Would you like to withdraw more money? ------- Y / N ");
			option = sc.nextLine();
			
			if(option.toUpperCase().equals("Y")) {
				// withdraw more.
				lc.logInfo("please choose the account you want to withdraw money.");
				accountId = Integer.parseInt(sc.nextLine());
				
				lc.logInfo("please enter the withdrawal amount (starts from 0)");
				deposit = Integer.parseInt(sc.nextLine());
				accountDao.transactMoney("-", deposit, accountId);
				
			} else if (option.toUpperCase().equals("N")) {
				// stop withdraw.
				stopWithdraw = true;
			} else {
				lc.logInfo("You press wrong button. please try again.\r\n");
			}
		}
		
		//transaction();
	}
	
	public static void transaction() {
		
		lc.logInfo("would you like to confirm the transaction? ---------- Y: confirm / N: cancel");
		option = sc.nextLine();
		if (option.toUpperCase().equals("Y")) {
			accountDao.commit();
			lc.logInfo("The transaction is confirmed permanently");
		} else if (option.toUpperCase().equals("N")){
			accountDao.rollback();
			lc.logInfo("The transaction is canceled.");
		} else {
			lc.logInfo("You press wrong button. please try again.");
		}
	}
	
	public static void logOut () {
		lc.logInfo("opps! log out.. it's so sad to say good bye!");
		userName = null;
		password = null;
	}
	
	
	
	
	
	
	
	
	
	/* can be used in main to print the log.
	 * 
	BasicConfigurator.configure();		// it configures log4j 		
	LoggingClass lc = new LoggingClass();
	
	try {
		BankUserDao bankUserDao = new BankUserDaoImpl();
		lc.logDebug(bankUserDao.getBankUser().toString());
	} catch (Exception e) {
		lc.logFatal(e);
	}*/
	
	/*public static int divide(int a, int b) {
		return a/b;
	}*/
}
