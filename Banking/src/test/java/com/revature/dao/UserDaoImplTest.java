package com.revature.dao;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.User;
import com.revature.exceptions.InvalidAccountIDException;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.InvalidPasswordException;

public class UserDaoImplTest {
	
	
	/*
	 * CREATING USERS
	 */
	
	@Test
	public final void createUserValidInput() {
		UserDaoImpl udi = new UserDaoImpl();
		
		String testInput = 	"ProDog3\n"+
							"ruhroh\n"+
							"Scooby\n"+
							"Doo\n";
		
		Scanner sc = new Scanner(testInput);
		User validUser = udi.createUser(sc);
		
		if(validUser.getFirstName().equals("Scooby") &&
				validUser.getLastName().equals("Doo") &&
				validUser.getUsername().equals("ProDog3")) {
			assert(true);
		}
		else
			assert(false);
	}
	
	@Test
	public final void createUserAlreadyExists() {
		UserDaoImpl udi = new UserDaoImpl();
		
		String testInput = 	"Bugsy\n"+
							"ProDog4\n"+
							"ruhroh\n"+
							"Scrappy\n"+
							"Doo\n";
		
		Scanner sc = new Scanner(testInput);
		User userAlreadyExists = udi.createUser(sc);
		
		if(userAlreadyExists.getFirstName().equals("Scrappy") &&
				userAlreadyExists.getLastName().equals("Doo") &&
				userAlreadyExists.getUsername().equals("ProDog4")) {
			assert(true);
		}
		else
			assert(false);
	}
	
	
	/*
	 * LOGGING IN
	 */
	
	@Test
	public final void successfulRegisteredUserLogIn() {
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Bugsy\n"+
							"xyz123\n";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.logIn(sc);
		
		if(user.getFirstName().equals("Bugs") &&
				user.getLastName().equals("Bunny") &&
				user.getUsername().equals("Bugsy")) {
			assert(true);
		}
		else
			assert(false);
	}
	
	@Test
	public final void registeredUserLogInInvalidPasswordException(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Bugsy\n"+
							"ddd\n"+
							"Bugsy\n"+
							"xyz123";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.logIn(sc);
		
		if(user.getFirstName().equals("Bugs") &&
				user.getLastName().equals("Bunny") &&
				user.getUsername().equals("Bugsy")) {
			assert(true);
		}
		else
			assert(false);
	}
	
	
	/*
	 * LOGGING IN AS SUPER USER
	 */
	
	@Test
	public final void successfulSuperUserLogIn(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"super\n"+
							"megaultrasuper\n";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.logIn(sc);
		
		if(user.getFirstName().equals("Master") &&
				user.getLastName().equals("Splinter") &&
				user.getUsername().equals("super")) {
			assert(true);
		}
		else
			assert(false);
	}
	
	@Test
	public final void invalidSuperUserLogIn(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"super\n"+
							"notsosuper\n"+
							"super\n"+
							"megaultrasuper";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.logIn(sc);
		
		if(user.getFirstName().equals("Master") &&
				user.getLastName().equals("Splinter") &&
				user.getUsername().equals("super")) {
			assert(true);
		}
		else
			assert(false);
	}
	
	
	/*
	 * SUPER METHODS
	 */
	
	//superView()
	
	@Test
	public final void superViewPrintsAccounts(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Bugs\n"+
							"1\n";
		
		Scanner sc = new Scanner(testInput);
		boolean worked = udi.superView(sc);
		
		assert(worked);
	}
	
	
	@Test
	public final void superViewNoSuchAccount(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Bugs\n"+
							"3\n";
		
		Scanner sc = new Scanner(testInput);
		boolean worked = udi.superView(sc);
		
		assert(!worked);
	}
	
	
	@Test
	public final void superViewNoSuchUser(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Bugsy\n";
		
		Scanner sc = new Scanner(testInput);
		boolean worked = udi.superView(sc);
		
		assert(!worked);
	}
	
	
	//superUpdate()
	
	@Test
	public final void superUpdateUser(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Scooby\n"+
							"20\n"+
							"PASS\n"+
							"rohruh\n";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.superUpdate(sc);
		
		if(user.getFirstName().equals("Scooby") && 
				user.getLastName().equals("Doo") &&
				user.getUserId() == 20 &&
				user.getUsername().equals("ProDog")) {
			assert(true);
		}
		else
			assert(false);
	}
	
	
	@Test
	public final void superUpdateUserInvalidOption(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Scooby\n"+
							"20\n"+
							"USERNAME\n";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.superUpdate(sc);
		
		if(user.getUserId() == -1) {
			assert(true);
		}
		else
			assert(false);
	}
	
	
	@Test
	public final void superUpdateUserInvalidID(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Scooby\n"+
							"20000000\n";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.superUpdate(sc);
		
		if(user.getUserId() == -2) {
			assert(true);
		}
		else
			assert(false);
	}
	
	
	@Test
	public final void superUpdateUserInvalidName(){
		UserDaoImpl udi = new UserDaoImpl();
		String testInput = 	"Charlie\n";
		
		Scanner sc = new Scanner(testInput);
		User user = udi.superUpdate(sc);
		
		if(user.getUserId() == -3) {
			assert(true);
		}
		else
			assert(false);
	}
	
	
	//superDelete
	
	@Test public void deleteExistingUser() {
		UserDaoImpl udi = new UserDaoImpl();
		
		String testInput = 	"TestDoge\n"+
							"wow\n"+
							"The\n"+
							"Doge\n";
		
		Scanner sc = new Scanner(testInput);
		User validUser = udi.createUser(sc);
		
		
		String testInput2 = "The\n"+
							validUser.getUserId()+"\n";
		
		sc = new Scanner(testInput2);
		
		int deletedUser = udi.superDelete(sc);
		
		if(deletedUser == validUser.getUserId()) {
			assert(true);
		}
		
		else
			assert(false);
	}
	
	
	@Test public void deleteNonExistantUserID() {
		UserDaoImpl udi = new UserDaoImpl();
		
		
		
		String testInput2 = "Bugs\n"+
							(-1)+"\n";
		
		Scanner sc = new Scanner(testInput2);
		
		int deletedUser = udi.superDelete(sc);
		
		if(deletedUser == -2) {
			assert(true);
		}
		
		else
			assert(false);
	}
	
	
	@Test public void deleteNonExistantName() {
		UserDaoImpl udi = new UserDaoImpl();
		
		String testInput2 = "Charlie\n";
		
		Scanner sc = new Scanner(testInput2);
		
		int deletedUser = udi.superDelete(sc);
		
		if(deletedUser == -1) {
			assert(true);
		}
		
		else
			assert(false);
	}
}
