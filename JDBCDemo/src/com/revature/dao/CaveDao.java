package com.revature.dao;

import java.util.List;

import com.revature.beans.Cave;

public interface CaveDao {

	List<Cave> getCaves();
	Cave getCaveById(int id);

}
