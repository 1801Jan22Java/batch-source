package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(int id) {

		return null;
	}

	@Override
	public List<User> getUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createQuery("from User").list();
		for (User u : users){
			System.out.println(u);
		}
		s.close();
		
		return users;
	}

	@Override
	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
