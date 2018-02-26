package com.revature.dao;

import java.util.List;

import com.revature.domains.AdoptionForm;

public interface AdoptionFormDao {
	public List<AdoptionForm> getAdoptionForm();
	public AdoptionForm getAdoptionFormById(int id);
	public int addAdoptionForm(AdoptionForm form);
	public void deleteAdoptionForm(AdoptionForm form);
	public void merge(AdoptionForm form);
	public void saveOrUpdate(AdoptionForm form);
}