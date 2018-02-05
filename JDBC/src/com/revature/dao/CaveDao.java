package com.revature.dao;

import java.util.List;

import com.revature.beans.Cave;

public interface CaveDao {
	
	public List<Cave> getCaves();
	public Cave getCaveById(int id);

}
