package com.revature.dao;

import java.util.List;

import com.revature.beans.Bear;

public class BearDaomlImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		return readBearsSAX(String filename);
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
private List<Bear> readBearsSAX(String filename){
	
}