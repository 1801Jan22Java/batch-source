package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Movie;
import com.revature.util.HibernateUtil;

public class MovieDaoImpl implements MovieDao{

	@Override
	public Movie getMovieById(int id) {
		Session s = HibernateUtil.getSession();
		Movie m = (Movie) s.get(Movie.class, id);
		s.close();
		return m;
	}

	@Override
	public int addMovie(Movie m) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(m);
		try {
			tx.commit();
		} catch (Exception e) {
			result = 0;
			tx.rollback();
		}
		return result;
	}

}
