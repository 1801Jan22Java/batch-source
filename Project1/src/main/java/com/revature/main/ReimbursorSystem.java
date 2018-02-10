package com.revature.main;

import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserOracle;

public class ReimbursorSystem {
	public static void main(String[] args) {
		UserOracle uo = new UserOracle();
		User user = uo.login("asdf", "asdf");
		System.out.println(user.getFirstname() +" "+user.getLastname());
		
		List<User> users = uo.getAllEmployees();
		for(User u : users) {
			System.out.println(u.getFirstname()+" "+u.getLastname());
		}
	}
}
