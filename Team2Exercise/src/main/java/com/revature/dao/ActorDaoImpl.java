package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Actor;
import com.revature.util.HibernateUtil;

public class ActorDaoImpl implements ActorDao{

	@Override
	public Actor getActorById(int id) {
		Session s = HibernateUtil.getSession();
		Actor a = (Actor) s.get(Actor.class, id);
		s.close();
		return a;
	}

	@Override
	public int addActor(Actor a) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(a);
		try {
			tx.commit();
		} catch (Exception e) {
			result = 0;
			tx.rollback();
		}
		return result;
	}


}
