package com.revature.dao;

import java.util.List;

import com.revature.beans.Bear;

public interface BearDao {

	public List<Bear> getBears();
	public Bear getBearById(int id);
	public void createBear(Bear bear);
	public void feedBear(int bearId, int beehiveId, int honeyAmt);
		
}
