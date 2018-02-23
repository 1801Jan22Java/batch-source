package com.revature.driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.dao.*;
import com.revature.domain.Animal;
import com.revature.domain.Bat;
import com.revature.domain.Bear;
import com.revature.domain.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		//caveInit();

		 //animalInit();
		 

		//moreAnimals();
		funWithCriteria();

	}

	// THIS SHOULD BE HAPPENING VIA DAO METHODS
		static void animalInit() {

			Session s = HibernateUtil.getSession();
			Transaction tx = s.beginTransaction();

			Cave c = (Cave) s.get(Cave.class, 2);

			Animal a = new Animal("Mystery", c);
			Bat bat1 = new Bat("Ernie", c, 46);
			Bear bear1 = new Bear("Fred", c, "Grizzly");

			s.save(a);
			s.save(bat1);
			s.save(bear1);

			tx.commit();
			s.close();

		}

	



	static void funWithCriteria() {
		Session s = HibernateUtil.getSession();
		// Bears that start with the letter G
		Criteria c1 = s.createCriteria(Animal.class);
		c1.add(Restrictions.like("name", "G%"));
		//c.add(Restrictions.eq("SPECIES", "bear"));
		c1.add(Restrictions.isNotNull("bearType"));
		List<Animal> animals1 = c1.list();
		System.out.println(animals1.toString());
		
		// Bats with wingspan between 50-100
		Criteria c2 = s.createCriteria(Animal.class);
		c2.add(Restrictions.between("wingspan", 50, 100));
		List<Animal> animals2 = c2.list();
		System.out.println(animals2.toString());
		
		// Sum of all wingspans
		Criteria c3 = s.createCriteria(Animal.class);
		c3.setProjection(Projections.sum("wingspan"));
		Long result3 = (Long) c3.uniqueResult();
		System.out.println(result3.toString());
		
		// Total number of bears
		Criteria c4 = s.createCriteria(Animal.class);
		c4.setProjection(Projections.count("bearType"));
		Long result4 = (Long) c4.uniqueResult();
		System.out.println(result4.toString());
		
		
		s.close();
		
		

	}

	

	static void caveInit() {

		Cave c1 = new Cave("Reston");
		Cave c2 = new Cave("Herndon");

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		s.persist(c1);
		s.persist(c2);

		tx.commit();
		s.close();
	}

	

	static void moreAnimals() {

		Cave c = new Cave(1, "Reston");

		Bat bat1 = new Bat("Frodo", c, 12);
		Bat bat2 = new Bat("Sam", c, 70);
		Bat bat3 = new Bat("Aragon", c, 140);
		Bear bear1 = new Bear("Gandalf", c, "Wizard");
		Bear bear2 = new Bear("Fred2", c, "Wizard");
		Bear bear3 = new Bear("Saruman", c, "Polar");

		List<Bear> bearList = new ArrayList<>();

		bearList.add(bear1);
		bearList.add(bear2);
		bearList.add(bear3);

		List<Bat> batList = new ArrayList<>();

		batList.add(bat1);
		batList.add(bat2);
		batList.add(bat3);
		
		BearDao bearDao = new BearDaoImpl();
		BatDao batDao = new BatDaoImpl();
		
		bearDao.addBears(bearList);
		batDao.addBats(batList);

	}
}