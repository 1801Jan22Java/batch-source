package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.AdoptionForm;
import com.revature.util.HibernateUtil;

public class AdoptionFormDaoImpl implements AdoptionFormDao{
	@Override
	public List<AdoptionForm> getAll() {
		Session s = HibernateUtil.getSession();
		List<AdoptionForm> a = s.createQuery("from AdoptionForm").list();
		s.close();
		return a;
	}

	@Override
	public AdoptionForm getById(int id) {
		Session s = HibernateUtil.getSession();
		AdoptionForm a = (AdoptionForm) s.get(AdoptionForm.class, id);
		return a;
	}

	@Override
	public int add(AdoptionForm a) {
		return (int) HibernateUtil.getSession().save(a);
	}

	@Override
	public void delete(AdoptionForm a) {
		HibernateUtil.getSession().delete(a);
	}

	@Override
	public void merge(AdoptionForm a) {
		HibernateUtil.getSession().merge(a);
	}

	@Override
	public void saveOrUpdate(AdoptionForm a) {
		HibernateUtil.getSession().saveOrUpdate(a);
	}
}
