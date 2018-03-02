package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.TRex;

@Repository("tRexRepository")
@Transactional
public class TRexDaoImpl implements TRexDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TRex> getAllTRex() {
		Session s = sessionFactory.getCurrentSession();
		List<TRex> dinoList = s.createCriteria(TRex.class).list();
		return dinoList;
	}

	@Override
	public void createTRex(TRex tRex) {
		sessionFactory.getCurrentSession().save(tRex);
	}

}
