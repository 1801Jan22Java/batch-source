package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.beans.Bear;

public interface BearDao {
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public boolean addBear(Bear newBear);
}
