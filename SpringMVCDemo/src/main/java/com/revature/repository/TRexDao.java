package com.revature.repository;

import java.util.List;

import com.revature.beans.TRex;

public interface TRexDao {
	
	public List<TRex> getAllTRex();
	public void createTRex(TRex tRex);
	

}
