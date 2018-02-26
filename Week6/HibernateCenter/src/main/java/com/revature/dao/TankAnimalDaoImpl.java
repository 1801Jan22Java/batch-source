package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.TankAnimal;
import com.revature.util.HibernateUtil;

public class TankAnimalDaoImpl implements TankAnimalDao {
	@Override
	public List<TankAnimal> getAll() {
		Session s = HibernateUtil.getSession();
		List<TankAnimal> t = s.createQuery("from TankAnimal").list();
		s.close();
		return t;
	}

	@Override
	public TankAnimal getById(int id) {
		Session s = HibernateUtil.getSession();
		TankAnimal t = (TankAnimal) s.get(TankAnimal.class, id);
		return t;
	}

	@Override
	public int add(TankAnimal t) {
		return (int) HibernateUtil.getSession().save(t);
	}

	@Override
	public void delete(TankAnimal t) {
		HibernateUtil.getSession().delete(t);
	}

	@Override
	public void merge(TankAnimal t) {
		HibernateUtil.getSession().merge(t);
	}

	@Override
	public void saveOrUpdate(TankAnimal t) {
		HibernateUtil.getSession().saveOrUpdate(t);
	}
}
