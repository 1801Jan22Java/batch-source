package com.revature.dao;

import java.util.List;

import com.revature.domains.AdoptionForm;

public interface AdoptionFormDao {
	public List<AdoptionForm> getAll();
	public AdoptionForm getById(int id);
	public int add(AdoptionForm a);
	public void delete(AdoptionForm a);
	public void merge(AdoptionForm a);
	public void saveOrUpdate(AdoptionForm a);
}