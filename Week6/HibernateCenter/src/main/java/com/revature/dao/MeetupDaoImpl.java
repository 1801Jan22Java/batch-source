package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.Meetup;
import com.revature.util.HibernateUtil;

public class MeetupDaoImpl implements MeetupDao{
	@Override
	public List<Meetup> getAll() {
		Session s = HibernateUtil.getSession();
		List<Meetup> m = s.createQuery("from Meetup").list();
		s.close();
		return m;
	}

	@Override
	public Meetup getById(int id) {
		Session s = HibernateUtil.getSession();
		Meetup m = (Meetup) s.get(Meetup.class, id);
		return m;
	}

	@Override
	public int add(Meetup m) {
		return (int) HibernateUtil.getSession().save(m);
	}

	@Override
	public void delete(Meetup m) {
		HibernateUtil.getSession().delete(m);
	}

	@Override
	public void merge(Meetup m) {
		HibernateUtil.getSession().merge(m);
	}

	@Override
	public void saveOrUpdate(Meetup m) {
		HibernateUtil.getSession().saveOrUpdate(m);
	}
}
