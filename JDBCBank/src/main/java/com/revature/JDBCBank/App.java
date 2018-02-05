package com.revature.JDBCBank;

import java.util.Scanner;
import com.revature.beans.User;
import com.revature.dao.ConnectionUtil;
import com.revature.dao.SuperUserDaoImpl;
import com.revature.dao.UserDaoImpl;
import cam.revature.exceptions.*;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Bank of Camp!");
        System.out.print("Would you like to (1)register or (2)login: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.print("Please enter your username: ");
        String username = sc.nextLine();
        System.out.print("Please enter your password: ");
        String password = sc.nextLine();
        User user = new User(username, password);
        UserDaoImpl dao = new UserDaoImpl();
        SuperUserDaoImpl suDao = new SuperUserDaoImpl();
        try {
        	ConnectionUtil.getConnection("bank.properties", user);
        	switch (option) {
        		case 1:	dao.registerUser(user);
        		case 2: dao.login(user);
        			break;
        		default: throw new InvalidUseCaseException();
        	}
        	loop: while (true){
        		System.out.println("Options for user: (1)view accounts, (2)create account, (3)delete account, (4)deposit account, (5)withdraw account, (6)logout");
        		if (user.getUserID() == 1) {
        			System.out.println("Options for superUser: (7)view users, (8)create user, (9)update user, (10)delete user");
        		}
        		System.out.print("Please select an option: ");
        		option = sc.nextInt();
        		sc.nextLine();
        		switch (option) {
        			case 1: dao.viewAccounts(user);
        				break;
        			case 2: System.out.print("Please enter balance for new account: ");
        				dao.newAccount(user, sc.nextDouble());
        				sc.nextLine();
        				break;
        			case 3: System.out.print("Please enter AccountID to be dropped: ");
        				dao.deleteAccount(user, sc.nextInt());
        				sc.nextLine();
        				break;
        			case 4: System.out.print("Please enter AccountID to deposit into: ");
        				int depositID = sc.nextInt();
        				sc.nextLine();
        				System.out.print("Please enter amount to deposit: ");
        				dao.depositAccount(user, depositID, sc.nextDouble());
        				sc.nextLine();
        				break;
        			case 5: System.out.print("Please enter AccountID to withdraw from: ");
    					int withdrawID = sc.nextInt();
    					sc.nextLine();
    					System.out.print("Please enter amount to withdraw: ");
    					dao.withdrawAccount(user, withdrawID, sc.nextDouble());
    					sc.nextLine();
    					break;
        			case 6: dao.logout(user);
        				System.out.print("Logged out!");
        				break loop;
        			case 7: if (user.getUserID() == 1) {
        				suDao.viewUsers(user);
        				break; }
        			case 8: if (user.getUserID() == 1) {
        				System.out.print("Please enter new username: ");
        				String NewUsername = sc.nextLine();
        				System.out.print("Please enter new password: ");
        				User tempUser = new User(NewUsername, sc.nextLine());
        				ConnectionUtil.getConnection("bank.properties", tempUser);
        				dao.registerUser(tempUser);
        				break; }
        			case 9: if (user.getUserID() == 1) {
        				System.out.print("Please enter UserID to be updated: ");
        				int userID = sc.nextInt();
        				sc.nextLine();
        				System.out.print("Please enter updated username: ");
        				String updUsername = sc.nextLine();
        				System.out.print("Please enter updated password: ");
        				suDao.updateUser(user, userID, updUsername, sc.nextLine());
        				break; }
        			case 10: if (user.getUserID() == 1) {
        				System.out.print("Please enter UserID to be deleted: ");
        				suDao.deleteUser(user, sc.nextInt());
        				sc.nextLine();
        				break; }
        			default: throw new InvalidUseCaseException();
        		}
        	}
        } catch (Exception e) {
        System.out.println(e.getMessage());
        } finally {
        sc.close();
        }
    }
}
