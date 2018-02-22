package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Genre;
import com.revature.util.HibernateUtil;

public class GenreDaoImpl implements GenreDao{

	@Override
	public Genre getGenreById(int id) {
		Session s = HibernateUtil.getSession();
		Genre g = (Genre) s.get(Genre.class, id);
		s.close();
		return g;
	}

	@Override
	public int addGenre(Genre g) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(g);
		try {
			tx.commit();
		} catch (Exception e) {
			result = 0;
			tx.rollback();
		}
		return result;
	}

}
