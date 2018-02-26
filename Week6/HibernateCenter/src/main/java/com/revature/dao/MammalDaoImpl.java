package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.Mammal;
import com.revature.util.HibernateUtil;

public class MammalDaoImpl implements MammalDao{
	@Override
	public List<Mammal> getAll() {
		Session s = HibernateUtil.getSession();
		List<Mammal> mammals = s.createQuery("from Mammal").list();
		s.close();
		return mammals;
	}

	@Override
	public Mammal getById(int id) {
		Session s = HibernateUtil.getSession();
		Mammal mammal = (Mammal) s.get(Mammal.class, id);
		return mammal;
	}

	@Override
	public int add(Mammal mammal) {
		return (int) HibernateUtil.getSession().save(mammal);
	}

	@Override
	public void delete(Mammal mammal) {
		HibernateUtil.getSession().delete(mammal);
	}

	@Override
	public void merge(Mammal mammal) {
		HibernateUtil.getSession().merge(mammal);
	}

	@Override
	public void saveOrUpdate(Mammal mammal) {
		HibernateUtil.getSession().saveOrUpdate(mammal);
	}
}
