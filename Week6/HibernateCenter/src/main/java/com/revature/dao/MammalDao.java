package com.revature.dao;

import java.util.List;

import com.revature.domains.Mammal;

public interface MammalDao {
	public List<Mammal> getAll();
	public Mammal getById(int id);
	public int add(Mammal lookup);
	public void delete(Mammal lookup);
	public void merge(Mammal lookup);
	public void saveOrUpdate(Mammal mammal);
}
