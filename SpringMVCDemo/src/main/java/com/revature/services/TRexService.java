package com.revature.services;

import java.util.List;

import com.revature.beans.TRex;

public interface TRexService {
	public List<TRex> getAllTRexes();
	public void addTRex(TRex trex);
}
