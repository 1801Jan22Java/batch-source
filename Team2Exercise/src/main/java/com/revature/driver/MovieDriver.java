package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class MovieDriver {

	public static void main (String args[]) {
		ActorDao ad = new ActorDaoImpl();
		GenreDao gd = new GenreDaoImpl();
		MovieDao md = new MovieDaoImpl();
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Genre g1 = new Genre("Comedy");
		Genre g2 = new Genre("Drama");
		
		gd.addGenre(g1);
		gd.addGenre(g2);
		
		Actor a1 = new Actor("Tom Hanks");
		Actor a2 = new Actor("Brad Pitt");
		
		ad.addActor(a1);
		ad.addActor(a2);
		
		
		Movie m1 = new Movie("Beyond All Boundaries");
		m1.getActors().add(a1);
		m1.getActors().add(a2);
		
		m1.getGenres().add(g2);
		md.addMovie(m1);
		
		tx.commit();
		s.close();
	}
}
