package com.revature.dao;

import java.util.List;

import com.revature.domains.User;

public interface UserDao {
	public List<User> getAll();
	public User getById(int id);
	public int add(User u);
	public void delete(User u);
	public void merge(User u);
	public void saveOrUpdate(User u);
}
