package com.revature.dao;

import java.util.List;

import com.revature.domains.UserFile;

public interface UserFileDao {
	public List<UserFile> getAll();
	public UserFile getById(int id);
	public int add(UserFile u);
	public void delete(UserFile u);
	public void merge(UserFile u);
	public void saveOrUpdate(UserFile u);
}
