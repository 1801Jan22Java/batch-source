package com.revature.dao;

import java.util.List;

import com.revature.beans.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public void addBear(int id);
	public void feedBear(int bearID, int beehiveID, int honeyAmount);

}