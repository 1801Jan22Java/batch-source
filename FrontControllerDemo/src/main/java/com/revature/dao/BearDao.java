package com.revature.dao;

import com.revature.beans.*;
import java.util.List;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearByID(int id);
	public void feedBear(int bearID, int beehive, int honeyAmt);
}
