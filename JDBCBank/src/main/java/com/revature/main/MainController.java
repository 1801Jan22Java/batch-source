package com.revature.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;
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
	public static int parsedNumber;

	public static void main(String[] args) {

		String[] info;

		// it configures log4j
		BasicConfigurator.configure();
		LoggingClass lc = new LoggingClass();

		lc.logInfo("Welcome to JDBC Bank!");
		boolean ifLoginSuccess = true;

		// repeat until login success.
		do {
			info = getInfo();
			userName = info[0];
			password = info[1];
			ifLoginSuccess = login(userName, password);

		} while (!ifLoginSuccess); // true - login success / false - login fail, re-try!

		lc.logInfo(userName + ", welcome! login success!");

		// get current log-in user's info
		userVo = userDao.getBankUserByName(userName);
		//lc.logDebug(userVo.toString());

		// while login, always comes back to the account information display.
		boolean ifStayInlogin = true;
		while (ifStayInlogin) {

			// check if has account.
			int accountCnt = accountDao.ifBankAccountExistByUserId(userVo.getId());

			// (1) if has more than an account
			if (accountCnt > 0) {

				// display account info and provide option.
				List<BankAccountVo> accountVoList = accountDao.getBankByUserId(userVo.getId());

				lc.logInfo("**** " + userVo.getName() + "'s Account Status ****");
				ArrayList<Integer> accountNos = new ArrayList<Integer>();

				for (BankAccountVo vo : accountVoList) {
					lc.logInfo("**** Account No. : " + vo.getId() + " / Total Balance : " + vo.getBalance());

					// collect only bankAccountId to check if the account exist or not.
					accountNos.add(vo.getId());
				}

				lc.logInfo("******************************************");
				lc.logInfo("---- Menu ");
				if (userVo.lv == 0) {
					lc.logInfo("---- press 201801 : manage users");
				}
				lc.logInfo("---- press 1 : create a new bank account");
				lc.logInfo("---- press 2 : make deposit");
				lc.logInfo("---- press 3 : withdrawal");
				lc.logInfo("---- press 4 : delete account");
				lc.logInfo("---- press 5 : log out");
				lc.logInfo("******************************************");
				option = sc.nextLine().trim();

				switch (option) {
				case "201801": // create new account
					superUserMainMenu();
					break;
				case "1": // create new account
					createNewBankAccount(userVo.getId());
					break;
				case "2": // make deposit
					addDepositMoney(accountNos);
					break;
				case "3": // withdraw
					minusDepositMoney(accountNos);
					break;
				case "4":
					deleteBankAccount(accountNos);
					break;
				case "5":
					logOut(); // initialize the user info
					ifStayInlogin = false;
					break;
				}

			} else {

				// (2) if account not exist, create account or log out.
				lc.logInfo("---- you have ZERO account.");

				if (userVo.lv == 0) {
					lc.logInfo("---- press 0 : manage users"); // 0 : manage user
				}
				lc.logInfo("---- press 1 : create a new bank account"); // 1 : create a bank account
				lc.logInfo("---- press 2 : log out"); // 2 : log out

				option = sc.nextLine().trim();

				if (option.equals("0")) {
					superUserMainMenu();

				} else if (option.equals("1")) {
					createNewBankAccount(userVo.getId());

				} else if (option.equals("2")) {
					logOut(); // initialize the user info
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

		String[] info = { userName, password };

		return info;
	}

	// 1. check if user exist 2. check if the password is right one
	public static Boolean login(String userName, String password) {

		boolean ifLoginSucceed = true;
		if (userDao.ifUserExist(userName) < 1) {
			ifLoginSucceed = false;
		} else if (userDao.ifRightPW(userName, password) < 1) {
			ifLoginSucceed = false;
		}
		return ifLoginSucceed;
	}

	/*
	 * SuperUser' Menu
	 */
	public static void superUserMainMenu() {
		// display all user account
		userDao.getBankUserWithTotalBalance();
		lc.logInfo("---- press 1 : create users");
		lc.logInfo("---- press 2 : delete users");
		lc.logInfo("---- press 3 : exit SUPERUSER menu");

		boolean ifRightOption = false;
		while (!ifRightOption) {
			ifRightOption = checkIfRightNumberFormat(sc.nextLine().trim());
		}
		switch (parsedNumber) {
		case 1: // 1: create user
			lc.logInfo("please enter user name");
			String newUsername = sc.nextLine();
			lc.logInfo("please enter user password");
			String newPassword = sc.nextLine();
			userDao.createBankUser(newUsername, newPassword);
			lc.logInfo("new user creation successfullly completed!! \r\n");
			boolean stopCreate = false;
			while(!stopCreate) {
				lc.logInfo("would you like to create more user? -------- Y / N");
				option = sc.nextLine().trim().toUpperCase();
				
				if(option.equals("Y")) {
					lc.logInfo("please enter user name");
					newUsername = sc.nextLine();
					lc.logInfo("please enter user password");
					newPassword = sc.nextLine();
					userDao.createBankUser(newUsername, newPassword);
					lc.logInfo("new user creation successfullly completed!! \r\n");
					stopCreate = false;
				} else if (option.equals("N")) {
					stopCreate = true;
				} else {
					lc.logInfo("please enter Y or N only."); // restart!
					stopCreate = false;
				}
			}
			break;
		case 2: // 2: delete user

			lc.logInfo("please enter user id");
			ifRightOption = checkIfRightNumberFormat(sc.nextLine().trim());
			int userId = parsedNumber;
			if (userDao.ifUserExist(userId) > 0) {
				accountDao.deleteBankAccountByUser(userId);
				userDao.deleteUser(userId);
			}

			boolean stopDelete = false;
			while (!stopDelete) { // repeatdly ask until right format option entered.

				lc.logInfo("would you like to delete more user? -------- Y / N");
				option = sc.nextLine().trim().toUpperCase();

				if (option.equals("Y")) {
					// delete.
					lc.logInfo("please enter user id");
					stopDelete = checkIfRightNumberFormat(sc.nextLine().trim()); // check if input is number
					userId = parsedNumber;
					if (userDao.ifUserExist(userId) > 0) { // if user exist, delete from 2 tables
						accountDao.deleteBankAccountByUser(userId);
						userDao.deleteUser(userId);
					}
					stopDelete = false;
				} else if (option.equals("N")) {
					// don't delete.
					stopDelete = true; // break while-loop and go back to the mainmenu.
				} else {
					lc.logInfo("please enter Y or N only."); // restart!
					stopDelete = false;
				}
			}
			break;
		case 3: 
			return;
		}
		

	}

	 
	/*
	 * BasicUser' Menu
	 */
	// create new bank account by userId
	public static void createNewBankAccount(int userId) {

		boolean ifRightOption = false;
		int initDeposit = 0;
		while (!ifRightOption) {
			lc.logInfo("please enter the initial deposit amount(starts from 0)\r\n");
			ifRightOption = checkIfRightNumberFormat(sc.nextLine().trim());
			initDeposit = parsedNumber;
		}
		accountDao.createBankAccount(initDeposit, userVo.getId());
		lc.logInfo("The new account is created.\r\n");

	}

	// add deposit
	public static void addDepositMoney(ArrayList<Integer> accountNos) {
		int accountId = 0;
		boolean ifExist = false;
		int deposit = 0;
		// first deposit 
		while (!ifExist) {
			lc.logInfo("please choose the account you want to add money.\r\n");
			ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
			accountId = parsedNumber;
			if (ifExist && !accountNos.contains(accountId)) {
				lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
				ifExist = false;
			}  
		}
		ifExist = false;
		while (!ifExist) {
			lc.logInfo("please enter the deposit amount (starts from 0)\r\n");
			ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
			deposit = parsedNumber;
			if (ifExist) {
				deposit = parsedNumber;
				accountDao.transactMoney("+", deposit, accountId);
				lc.logInfo("Making Deposit completed!!\r\n");
				ifExist = true;
			}  
		}
		// sequencial deposit by option
		boolean stopAdd = false;
		while (!stopAdd) {
			lc.logInfo("Would you like to add more money? ------- Y / N  \r\n");
			option = sc.nextLine();

			if (option.toUpperCase().equals("Y")) {
				ifExist = false;
				while (!ifExist) {
					lc.logInfo("please choose the account you want to add money.");
					ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
					accountId = parsedNumber;
					if (ifExist && !accountNos.contains(accountId)) {
						lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
						ifExist = false;
					}  
				}
				ifExist = false;
				while (!ifExist) {
					lc.logInfo("please enter the deposit amount (starts from 0)\r\n");
					ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
					deposit = parsedNumber;
					if (ifExist) {
						deposit = parsedNumber;
						accountDao.transactMoney("+", deposit, accountId);
						lc.logInfo("Making Deposit completed!!\r\n");
						ifExist = true;
					}  
				}

			} else if (option.toUpperCase().equals("N")) {
				stopAdd = true;
			} else {
				lc.logInfo("You press wrong button. please try again. \r\n");
				stopAdd = false;
			}
		}
		// transaction(); // Connection's auto commit control doesn't work.
	}
	
	
	// minus deposit
	public static void minusDepositMoney(ArrayList<Integer> accountNos) {
		
		
		int accountId = 0;
		int withdrawal = 0;
		boolean ifExist = false;
		while (!ifExist) {
			lc.logInfo("please choose the account you want to withdraw money.\r\n");
			ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
			accountId = parsedNumber;
			if (ifExist && !accountNos.contains(accountId)) {
				lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
				ifExist = false;
			}  
		}
		ifExist = false;
		while (!ifExist) {
			lc.logInfo("please enter the withdrawal amount (starts from 0)");
			ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
			withdrawal = parsedNumber;
			if (ifExist && accountDao.getBankAccountByAccountId(accountId).getBalance() >= withdrawal) {
				withdrawal = parsedNumber;
				accountDao.transactMoney("-", withdrawal, accountId);
				lc.logInfo("Withdrawal completed!!\r\n");
				ifExist = true;
			} else if (ifExist && accountDao.getBankAccountByAccountId(accountId).getBalance() < withdrawal) {
				lc.logInfo("Not enough balance. please try again. \r\n");
				ifExist = false;
			}
		}

		boolean stopWithdraw = false;
		while (!stopWithdraw) {
			lc.logInfo("Would you like to withdraw more money? ------- Y / N ");
			option = sc.nextLine().toUpperCase().trim();

			if (option.equals("Y")) {
				ifExist = false;
				while (!ifExist) {
					lc.logInfo("please choose the account you want to withdraw money.\r\n");
					ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
					accountId = parsedNumber;
					if (ifExist && !accountNos.contains(accountId)) {
						lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
						ifExist = false;
					}  
				}
				ifExist = false;
				while (!ifExist) {
					lc.logInfo("please enter the withdrawal amount (starts from 0)\r\n");
					ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
					withdrawal = parsedNumber;
					if (ifExist && accountDao.getBankAccountByAccountId(accountId).getBalance() >= withdrawal) {
						withdrawal = parsedNumber;
						accountDao.transactMoney("-", withdrawal, accountId);
						lc.logInfo("Withdrawal completed!!\r\n");
						ifExist = true;
					} else if (ifExist && accountDao.getBankAccountByAccountId(accountId).getBalance() < withdrawal) {
						lc.logInfo("Not enough balance. please try again. \r\n");
						ifExist = false;
					}
				}
				stopWithdraw = false;
			} else if (option.equals("N")) {
				stopWithdraw = true;
			} else {
				lc.logInfo("You press wrong button. please try again. \r\n");
				stopWithdraw = false;
			}
		}

		// transaction();
	}

	
	public static void deleteBankAccount(ArrayList<Integer> accountNos) {

		// 1. check if the account exist.
		int accountId = 0;
		boolean ifExist = false;
		
		// first delete.
		while (!ifExist) {
			lc.logInfo("please choose the account you want to delete.  ");
			ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
			accountId = parsedNumber;
			
			if (ifExist && !accountNos.contains(accountId)) {
				lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
				ifExist = false;
			}   
		}
				 
		BankAccountVo vo1 = accountDao.getBankAccountByAccountId(accountId);
		if (vo1.getBalance() > 0) {
			// if it has more then 0 balance, can't be deleted.
			lc.logInfo("The Account " + accountId + " has more than 0$. please withdraw all balance first.\r\n");
			lc.logInfo("Deleting an account is canceled.\r\n");
			return;
		} else {
			// if it's balance is 0, delete.
			accountDao.deleteBankAccountByAccount(accountId);
			lc.logInfo("Deleting the account "+ accountId + " is completed.\r\n");
			ifExist = true;
		}
		
		
		boolean stopDelete = false;
		while (!stopDelete) {
			lc.logInfo("would you like to delete more account? --- Y / N");
			option = sc.nextLine().trim().toUpperCase();
			
			if (option.equals("Y")) {
				
				// first delete.
				while (!ifExist) {
					lc.logInfo("please choose the account you want to delete. if you want exit, please press N.");
					ifExist = checkIfRightNumberFormat(sc.nextLine().trim()); // if not number, returns false
					accountId = parsedNumber;
					
					if (ifExist && !accountNos.contains(accountId)) {
						lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
						ifExist = false;
					}   
				}
				
				BankAccountVo vo2 = accountDao.getBankAccountByAccountId(accountId);
				if (vo2.getBalance() > 0) {
					// if it has more then 0 balance, can't be deleted.
					lc.logInfo("The Account " + accountId + " has more than 0$. please withdraw all balance first.\r\n");
					lc.logInfo("Deleting an account is canceled.\r\n");
					return;
				} else {
					// if it's balance is 0, delete.
					accountDao.deleteBankAccountByAccount(accountId);
					lc.logInfo("Deleting the account "+ accountId + " is completed./r/n");
					ifExist = true;
				}
				stopDelete = false;
			} else if (option.equals("N")){
				stopDelete = true;
			} else {
				lc.logInfo("You press wrong button. please try again.\r\n");
				stopDelete = false;
			}
		}
		 
	}

	
	public static List<BankUserVo> getBankUsers() {
		List<BankUserVo> userVos = userDao.getBankUser();
		for (BankUserVo vo : userVos) {
			lc.logInfo("user Id:" + vo.getId() + " / user Name: " + vo.getName());
		}
		return userVos;
	}

	public static void logOut() {
		lc.logInfo("opps! log out.. it's so sad to say good bye!");
		userName = null;
		password = null;
	}

	// check whenever parseInt is done
	public static boolean checkIfRightNumberFormat(String actuallyNumber) {
		boolean ifRight = false;
		try {
			parsedNumber = Integer.parseInt(actuallyNumber);
			ifRight = true;
		} catch (NumberFormatException e) {
			lc.logInfo("please enter only number. Anything but number is not allowed.\r");
		}
		return ifRight;
	}

	
	
	
	/*
	 * public static void transaction() {
	 * 
	 * lc.
	 * logInfo("would you like to confirm the transaction? ---------- Y: confirm / N: cancel"
	 * ); option = sc.nextLine(); if (option.toUpperCase().equals("Y")) {
	 * accountDao.commit(); lc.logInfo("The transaction is confirmed permanently");
	 * } else if (option.toUpperCase().equals("N")){ accountDao.rollback();
	 * lc.logInfo("The transaction is canceled."); } else {
	 * lc.logInfo("You press wrong button. please try again."); } }
	 */

	/*
	 * can be used in main to print the log.
	 * 
	 * BasicConfigurator.configure(); // it configures log4j LoggingClass lc = new
	 * LoggingClass();
	 * 
	 * try { BankUserDao bankUserDao = new BankUserDaoImpl();
	 * lc.logDebug(bankUserDao.getBankUser().toString()); } catch (Exception e) {
	 * lc.logFatal(e); }
	 */

	/*
	 * public static int divide(int a, int b) { return a/b; }
	 */
}
