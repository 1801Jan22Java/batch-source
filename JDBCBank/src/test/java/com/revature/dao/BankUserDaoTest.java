package com.revature.dao;

import org.junit.Test;

import com.revature.vo.BankUserVo;

import static org.junit.Assert.*;

public class BankUserDaoTest {

	public static BankUserDao userDao = new BankUserDaoImpl();
	
	@Test	// check if it returns right value for the parameter.
	public void testGetBankUserByName() {
		BankUserVo userVo1 = new BankUserVo(1, "SUPERUSER", "1234", 0);
		
		BankUserVo userVo2 = userDao.getBankUserByName("SUPERUSER");
		assertEquals(userVo1, userVo2);
	}
	
	@Test 	
	public void testIfUserExist() {
		int cnt = userDao.ifUserExist("TomCruise");
		assertEquals(0, cnt);
		
		int cnt2 = userDao.ifUserExist("SUPERUSER");
		assertEquals(1, cnt2);
	}

	@Test
	public void testIfRightPw() {
		int cnt = userDao.ifRightPW("SUPERUSER", "1234");
		assertNotEquals(0, cnt);
	}

	@Test
	public void createBankUser() {
		int beforeInsert = userDao.getBankUser().size();
		userDao.createBankUser("neweuser", "1234");
		int afterInsert = userDao.getBankUser().size();
		assertEquals(beforeInsert, afterInsert);
	}
	
	
}
