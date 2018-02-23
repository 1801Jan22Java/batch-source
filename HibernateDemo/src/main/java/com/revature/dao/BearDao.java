package com.revature.dao;

import java.util.List;

import com.revature.domain.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	
	public Bear getBearById(int id);
	
	public void addBears(List<Bear> bearList);

}
