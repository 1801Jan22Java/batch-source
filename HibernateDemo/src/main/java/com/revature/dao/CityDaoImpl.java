package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class CityDaoImpl implements CityDao {

	@Override
	public City getCityById(int id) {
		Session s = HibernateUtil.getSession();
		City thisCity = (City) s.get(City.class, id);
		s.close();
		return thisCity;
	}

	@Override
	public int addCity(City thisCity) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(thisCity);
		try {
			tx.commit();
		} catch (Exception e) {
			result = 0;
			tx.rollback();
		}
		return result;
	}

}
