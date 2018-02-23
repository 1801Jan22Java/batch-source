package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Bat;
import com.revature.util.HibernateUtil;

public class BatDaoImpl implements BatDao {
	
	@Override
	public List<Bat> getBats() {
		Session s = HibernateUtil.getSession();
		List<Bat> bats = s.createQuery("from Bat").list();
		for (Bat f : bats) {
			System.out.println(f);
		}
		s.close();
		return bats;
	}

	@Override
	public Bat getBatById(int id) {
		Session s = HibernateUtil.getSession();
		Bat b = (Bat) s.get(Bat.class, id);
		s.close();
		return b;
	}

	@Override
	public void addBats(List<Bat> batList) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		for (Bat b : batList) {
			s.persist(b);
		}
		tx.commit();
		s.close();
	}

}
