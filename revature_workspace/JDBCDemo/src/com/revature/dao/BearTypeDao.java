package com.revature.dao;

import java.util.List;

import com.revature.beans.BearType;

public interface BearTypeDao {
	public List<BearType> getBearType();
	public BearType getBearTypeById(int id);

	
}
