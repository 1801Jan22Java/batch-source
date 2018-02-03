package com.revature.dao;

import java.util.List;

import com.revature.beans.Cave;

public interface BearDao {

	public List<Cave> getBear();
	public Cave getCaveById(int id);
}
