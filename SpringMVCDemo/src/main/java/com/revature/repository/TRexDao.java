package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.beans.TRex;

@Repository
public interface TRexDao {

	List<TRex> getAllTRex();
	public void createTRex(TRex tRex);
	
}
