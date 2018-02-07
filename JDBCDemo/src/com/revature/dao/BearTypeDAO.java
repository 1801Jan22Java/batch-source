package com.revature.dao;

import java.util.List;

import com.revature.beans.BearType;

public interface BearTypeDAO {
	public List<BearType> getBearTypes();
	public BearType getBearTypeById(int id);
}
