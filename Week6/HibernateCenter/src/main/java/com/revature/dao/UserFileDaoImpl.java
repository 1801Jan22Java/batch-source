package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.UserFile;
import com.revature.util.HibernateUtil;

public class UserFileDaoImpl implements UserFileDao{
	@Override
	public List<UserFile> getAll() {
		Session s = HibernateUtil.getSession();
		List<UserFile> u = s.createQuery("from UserFile").list();
		s.close();
		return u;
	}

	@Override
	public UserFile getById(int id) {
		Session s = HibernateUtil.getSession();
		UserFile u = (UserFile) s.get(UserFile.class, id);
		return u;
	}

	@Override
	public int add(UserFile u) {
		return (int) HibernateUtil.getSession().save(u);
	}

	@Override
	public void delete(UserFile u) {
		HibernateUtil.getSession().delete(u);
	}

	@Override
	public void merge(UserFile u) {
		HibernateUtil.getSession().merge(u);
	}

	@Override
	public void saveOrUpdate(UserFile u) {
		HibernateUtil.getSession().saveOrUpdate(u);
	}
}
