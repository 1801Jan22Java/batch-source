package com.revature.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.beans.Whale;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		//init();
		test();
	}

	private static void test() {
		UserDao userDao = new UserDaoImpl();
		//System.out.println(userDao.getUsers());
		userDao.getUsers();
	}
	
	private static void init() {
		System.out.println();
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		User user = new User("RickyBobby", "1234");
		Whale whale = new Whale("Killer");
		
		//s.persist(user);
		//s.persist(whale);
		
		s.save(user);
		s.save(whale);
		
		tx.commit();
		s.close();
	}
}
