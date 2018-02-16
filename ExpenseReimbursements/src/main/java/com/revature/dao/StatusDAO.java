package com.revature.dao;

import java.util.List;

import com.revature.beans.Status;

public interface StatusDAO {
	public Status getStatusById(int id);
	public List<Status> viewAllStatus();
}
