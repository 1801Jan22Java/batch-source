package com.revature.dao;

import static org.junit.Assert.assertNotNull;



import org.junit.Test;

import com.revature.beans.Users;


public class UsersDaoImplTest {

	UsersDao ud = new UsersDaoImpl();
	Users user = new Users(1062, "notaman", "riga", "bertino the third", "DEL", 2);
	
	
	@Test
	public final void UserTesting() {
		
		assertNotNull(ud.checkPassword("DEL"));
		
		assertNotNull(ud.createUser("ironman","food", "for", "thought", 2));
		
		assertNotNull(ud.getAllUsers());
		
		assertNotNull(ud.getNextBankNum());
		
		assertNotNull(ud.getUserByAccount("notaman"));
		
		assertNotNull(ud.modifyUserField("USER_FNAME", "rigatina", user));
		
		
	}
	
}
