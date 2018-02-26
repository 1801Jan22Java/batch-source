package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.AnimalFile;
import com.revature.util.HibernateUtil;

public class AnimalFileDaoImpl implements AnimalFileDao{

	@Override
	public List<AnimalFile> getAll() {
		Session s = HibernateUtil.getSession();
		List<AnimalFile> animalFiles = s.createQuery("from animalFile").list();
		s.close();
		return animalFiles;
	}

	@Override
	public AnimalFile getById(int id) {
		Session s = HibernateUtil.getSession();
		AnimalFile animalFile = (AnimalFile) s.get(AnimalFile.class, id);
		return animalFile;
	}

	@Override
	public int add(AnimalFile animalFile) {
		return (int) HibernateUtil.getSession().save(animalFile);
	}

	@Override
	public void delete(AnimalFile animalFile) {
		HibernateUtil.getSession().delete(animalFile);
	}

	@Override
	public void merge(AnimalFile animalFile) {
		HibernateUtil.getSession().merge(animalFile);
	}

	@Override
	public void saveOrUpdate(AnimalFile animalFile) {
		HibernateUtil.getSession().saveOrUpdate(animalFile);
	}

}
