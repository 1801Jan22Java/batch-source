package com.revature.dao;

import java.util.List;

import com.revature.beans.Cave;

public interface CaveDAO {
	
	public List<Cave> getCaves();
	public Cave getCaveById(int id);
}
