package com.revature.dao;

import java.util.List;

import com.revature.beans.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public void buildABear(int type, String name, int caveId, int weight, String birthdate);

}
