package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.revature.domains.LookupTable;
import com.revature.util.HibernateUtil;

public class LookupTableDaoImpl implements LookupTableDao{

	@Override
	public List<LookupTable> getAll() {
		Session s = HibernateUtil.getSession();
		List<LookupTable> lookups = s.createQuery("from LookupTable").list();
		s.close();
		return lookups;
	}

	@Override
	public LookupTable getById(int id) {
		Session s = HibernateUtil.getSession();
		LookupTable lookup = (LookupTable) s.get(LookupTable.class, id);
		return lookup;
	}
	
	@Override
	public LookupTable getByColumnAndValue(String columnName, String value) {
		Session s = HibernateUtil.getSession();
		Criteria criteria = s.createCriteria(LookupTable.class);
		Criterion restriction = Restrictions.and(Restrictions.eq("COLUMN_NAME", columnName), Restrictions.eq("KEYWORD", value));
		criteria.add(restriction);
		LookupTable lookup = (LookupTable) criteria.uniqueResult();
		return lookup;
	}

	@Override
	public int add(LookupTable lookup) {
		return (int) HibernateUtil.getSession().save(lookup);
	}

	@Override
	public void delete(LookupTable lookup) {
		HibernateUtil.getSession().delete(lookup);
	}

	@Override
	public void merge(LookupTable lookup) {
		HibernateUtil.getSession().merge(lookup);
	}

	@Override
	public void saveOrUpdate(LookupTable lookup) {
		HibernateUtil.getSession().saveOrUpdate(lookup);
	}
}
