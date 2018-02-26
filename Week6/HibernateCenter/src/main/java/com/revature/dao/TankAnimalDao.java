package com.revature.dao;

import java.util.List;

import com.revature.domains.TankAnimal;

public interface TankAnimalDao {
	public List<TankAnimal> getAll();
	public TankAnimal getById(int id);
	public int add(TankAnimal t);
	public void delete(TankAnimal t);
	public void merge(TankAnimal t);
	public void saveOrUpdate(TankAnimal t);
}
