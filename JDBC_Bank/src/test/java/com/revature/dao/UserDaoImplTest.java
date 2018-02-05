package com.revature.dao;

import org.junit.Test; 

import com.revature.beans.User;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserDaoImplTest {

	@Test
	public void usersNotEmptyTest() {
		User u = new User("John", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		UserDaoImpl UDI = new UserDaoImpl();
		UDI.addUser(u);
		assertNotNull(UDI.getUsers());
	}
	
	@Test
	public void containsUsernameTest() {
		User u = new User("John", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		UserDaoImpl UDI = new UserDaoImpl();
		UDI.addUser(u);
		ArrayList<User> usrs = new ArrayList<User>();
		usrs.add(u);
		assert(UDI.contains(usrs, u.getUserName()));
	}
	
	@Test
	public void getByUsernameTest() {
		User u = new User("John", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		UserDaoImpl UDI = new UserDaoImpl();
		UDI.addUser(u);
		ArrayList<User> usrs = new ArrayList<User>();
		usrs.add(u);
		assertNotNull(UDI.getUserByUsername(u.getUserName()));
	}
	
	@Test 
	public void getUsernamesTest() {
		User u = new User("John", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		User m = new User("Jack", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		User r = new User("Mary", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		User t = new User("Sarah", "Doe", "John", "Doe", LocalDate.now(), "John@Doe.com", LocalDate.now(), 1);
		
		UserDaoImpl UDI = new UserDaoImpl();
		ArrayList<String> testNames = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<User> usrs = new ArrayList<User>();
		usrs.add(u);
		usrs.add(m);
		usrs.add(r);
		usrs.add(t);
		testNames.add("John");
		testNames.add("Jack");
		testNames.add("Mary");
		testNames.add("Sarah");
		result = UDI.getUserNames(usrs);
		for(int s = 0; s < result.size(); s++) {
			assert(result.get(s).equals(testNames.get(s)));
		}
		
		
	}
	
	

}
