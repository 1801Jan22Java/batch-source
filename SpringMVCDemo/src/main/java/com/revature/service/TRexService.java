package com.revature.service;

import java.util.List;

import com.revature.beans.TRex;

public interface TRexService {

	public List<TRex> getAllTRexes();
	public void addTRex(TRex tRex);
	
}
