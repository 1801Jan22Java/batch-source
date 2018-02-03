package com.revature.dao;

import java.util.List;

import com.revature.beans.Bear;

public interface BearDao {
	public void feedBear(int bearID,int beehiveID,int amthoney);
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public void addBear(Bear bear);
	
}
