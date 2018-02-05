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
		lc.logDebug(userVo.toString());

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
				default:
					lc.logInfo("wrong input. please try again.\r\n");
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
		List<BankUserVo> users = userDao.getBankUserWithTotalBalance();
		lc.logInfo("---- press 1 : create users");
		lc.logInfo("---- press 2 : delete users");

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
			lc.logInfo("new user creation successfullly completed!!");
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
				} else if (option.equals("N")) {
					// don't delete.
					stopDelete = true; // break while-loop and go back to the mainmenu.
				} else {
					lc.logInfo("please enter Y or N only."); // restart!
				}
			}
		}

	}

	public static void deleteBankAccount(ArrayList<Integer> accountNos) {

		// 1. check if the account exist.

		boolean ifRight = false;
		while (!ifRight) {
			lc.logInfo("please enter the account ID you want to delete.");
			ifRight = checkIfRightNumberFormat(sc.nextLine().trim()); // if it's number, returns true.

			int accountId = parsedNumber; // get account
			// check if the account exists.
			if (!accountNos.contains(accountId)) {
				lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
				continue;
			}
			// check if the account has balance over 0.
			BankAccountVo vo = accountDao.getBankAccountByAccountId(accountId);

			if (vo.getBalance() > 0) {
				// if it has more then 0 balance, can't be deleted.
				lc.logInfo("The Account " + accountId + " has more than 0$. please withdraw all balance first.");
				lc.logInfo("Deleting an account is canceled.");

				lc.logInfo("would you like to delete more account? --- Y / N");
				option = sc.nextLine().trim().toUpperCase();
				if (option.equals("Y")) {
					continue;
				} else if (option.equals("N")) {
					ifRight = true;
				} else {
					lc.logDebug("invalid option. Delete transaction is over.");
					ifRight = true;
				}
			} else {
				// if it's balance is 0, delete.
				accountDao.deleteBankAccountByAccount(accountId);
				lc.logInfo("Cancelation the account is completed./r/n");
			}
		}

		ifRight = false;
		while (ifRight) {
			lc.logInfo("would you like to delete more account?");
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
			lc.logInfo("please enter the initial deposit amount(starts from 0)");
			ifRightOption = checkIfRightNumberFormat(sc.nextLine().trim());
			initDeposit = parsedNumber;
		}
		accountDao.createBankAccount(initDeposit, userVo.getId());
		lc.logInfo("The new account is created./r/n");

	}

	// add deposit
	public static void addDepositMoney(ArrayList<Integer> accountNos) {
		int accountId = 0;
		boolean ifRightOption = false;

		while (!ifRightOption) {
			lc.logInfo("please choose the account you want to add money.");
			ifRightOption = checkIfRightNumberFormat(sc.nextLine().trim());
			accountId = parsedNumber;
		}

		if (!accountNos.contains(accountId)) {
			lc.logInfo("The account no " + accountId + " doesn't exist. please choose from existing accounts.\r\n");
			return;
		}

		lc.logInfo("please enter the deposit amount (starts from 0)");
		ifRightOption = checkIfRightNumberFormat(sc.nextLine().trim());
		int deposit = parsedNumber;
		accountDao.transactMoney("+", deposit, accountId);

		boolean stopAdd = true;
		while (!stopAdd) {

			lc.logInfo("Would you like to add more money? ------- Y / N ");
			option = sc.nextLine();

			if (option.toUpperCase().equals("Y")) {
				lc.logInfo("please choose the account you want to add money.");
				stopAdd = checkIfRightNumberFormat(sc.nextLine().trim());
				accountId = parsedNumber;
				if (!accountNos.contains(accountId)) {
					lc.logInfo("wrong account information. please choose existing account.\r\n");
					return;
				}

				lc.logInfo("please enter the deposit amount (starts from 0)");
				stopAdd = checkIfRightNumberFormat(sc.nextLine().trim());
				deposit = parsedNumber;
				accountDao.transactMoney("+", deposit, accountId);

			} else if (option.toUpperCase().equals("N")) {
				stopAdd = true;
			} else {
				lc.logInfo("You press wrong button. please try again. \r\n");
			}
		}
		// transaction(); // Connection's auto commit control doesn't work.
	}

	// minus deposit
	public static void minusDepositMoney(ArrayList<Integer> accountNos) {
		lc.logInfo("please choose the account you want to withdraw money.");
		int accountId = Integer.parseInt(sc.nextLine());

		if (!accountNos.contains(accountId)) {
			lc.logInfo("wrong account information. please choose existing account.\r\n");
			return;
		}

		lc.logInfo("please enter the withdrawal amount (starts from 0)");

		int deposit = Integer.parseInt(sc.nextLine());
		accountDao.transactMoney("-", deposit, accountId);

		boolean stopWithdraw = false;
		while (!stopWithdraw) {
			lc.logInfo("Would you like to withdraw more money? ------- Y / N ");
			option = sc.nextLine();

			if (option.toUpperCase().equals("Y")) {
				// withdraw more.
				lc.logInfo("please choose the account you want to withdraw money.");
				stopWithdraw = checkIfRightNumberFormat(sc.nextLine().trim());
				accountId = parsedNumber;

				lc.logInfo("please enter the withdrawal amount (starts from 0)");
				stopWithdraw = checkIfRightNumberFormat(sc.nextLine().trim());
				deposit = parsedNumber;

				accountDao.transactMoney("-", deposit, accountId);

			} else if (option.toUpperCase().equals("N")) {
				// stop withdraw.
				stopWithdraw = true;
			} else {
				lc.logInfo("You press wrong button. please try again.\r\n");
			}
		}

		// transaction();
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
			lc.logInfo("please enter only account number. Anything but number is not allowed.\r");
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
