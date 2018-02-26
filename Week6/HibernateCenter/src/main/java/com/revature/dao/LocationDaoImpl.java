package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.Location;
import com.revature.util.HibernateUtil;

public class LocationDaoImpl implements LocationDao{

	@Override
	public List<Location> getAll() {
		Session s = HibernateUtil.getSession();
		List<Location> locations = s.createQuery("from Location").list();
		s.close();
		return locations;
	}

	@Override
	public Location getById(int id) {
		Session s = HibernateUtil.getSession();
		Location location = (Location) s.get(Location.class, id);
		return location;
	}

	@Override
	public int add(Location location) {
		return (int) HibernateUtil.getSession().save(location);
	}

	@Override
	public void delete(Location location) {
		HibernateUtil.getSession().delete(location);
	}

	@Override
	public void merge(Location location) {
		HibernateUtil.getSession().merge(location);
	}

	@Override
	public void saveOrUpdate(Location location) {
		HibernateUtil.getSession().saveOrUpdate(location);
	}

}
