package com.revature.dao;

import java.util.List;

import com.revature.domains.LookupTable;

public interface LookupTableDao {
	public List<LookupTable> getAll();
	public LookupTable getById(int id);
	public LookupTable getByColumnAndValue(String columnName, String value);
	public int add(LookupTable lookup);
	public void delete(LookupTable lookup);
	public void merge(LookupTable lookup);
	public void saveOrUpdate(LookupTable lookup);
}
