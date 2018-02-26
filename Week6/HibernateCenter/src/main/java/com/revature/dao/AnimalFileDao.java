package com.revature.dao;

import java.util.List;

import com.revature.domains.Animal;
import com.revature.domains.AnimalFile;

public interface AnimalFileDao {
	public List<AnimalFile> getAll();
	public AnimalFile getById(int id);
	public int add(AnimalFile animalFile);
	public void delete(AnimalFile animalFile);
	public void merge(AnimalFile animalFile);
	public void saveOrUpdate(AnimalFile animalFile);
}
