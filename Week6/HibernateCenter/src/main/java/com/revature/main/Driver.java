package com.revature.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.domains.*;

import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		init();

		// FlashcardDao fd = new FlashcardDaoImpl();

		// saveAndPersist(fd);

		// fd.getFlashcards();

		// updateAndMerge();

		// Category c1 = new Category (1, "coding");
		// funWithNamedQueries(c1);

		//funWithCache();

		//caveInit();
		//animalInit();
		
		//moreAnimals();
		
		//testProjections();

	}

	static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		LookupTable lookup1 = new LookupTable ("Maturity", "Infant");
		LookupTable lookup2 = new LookupTable ("Maturity", "Young");
		LookupTable lookup3 = new LookupTable ("Maturity", "Adolescent");
		LookupTable lookup4 = new LookupTable ("Maturity", "Adult");
		LookupTable lookup5 = new LookupTable ("Maturity", "Mature");
		
		LookupTable lookup6 = new LookupTable ("Size", "Tiny");
		LookupTable lookup7 = new LookupTable ("Size", "Smalll");
		LookupTable lookup8 = new LookupTable ("Size", "Medium");
		LookupTable lookup9 = new LookupTable ("Size", "Large");
		LookupTable lookup10 = new LookupTable ("Size", "X-Large");
		
		LookupTable lookup11 = new LookupTable ("Color", "Black");
		LookupTable lookup12 = new LookupTable ("Color", "White");
		LookupTable lookup13 = new LookupTable ("Color", "Grey");
		LookupTable lookup14 = new LookupTable ("Color", "Red");
		LookupTable lookup15 = new LookupTable ("Color", "Orange");
		LookupTable lookup16 = new LookupTable ("Color", "Yellow");
		LookupTable lookup17 = new LookupTable ("Color", "Green");
		LookupTable lookup18 = new LookupTable ("Color", "Blue");
		LookupTable lookup19 = new LookupTable ("Color", "Purple");
		LookupTable lookup20 = new LookupTable ("Color", "Spotted");
		
		LookupTable lookup21 = new LookupTable ("Gender", "Male");
		LookupTable lookup22 = new LookupTable ("Gender", "Female");
		
		LookupTable lookup23 = new LookupTable ("Animal_Type", "Dog");
		LookupTable lookup24 = new LookupTable ("Animal_Type", "Cat");
		LookupTable lookup25 = new LookupTable ("Animal_Type", "Hamster");
		LookupTable lookup26 = new LookupTable ("Animal_Type", "Mouse");
		LookupTable lookup27 = new LookupTable ("Animal_Type", "Rabbit");
		LookupTable lookup28 = new LookupTable ("Animal_Type", "Ferret");
		LookupTable lookup29 = new LookupTable ("Animal_Type", "Chincilla");
		
		LookupTable lookup30 = new LookupTable ("Breed", "Labrador");
		LookupTable lookup31 = new LookupTable ("Breed", "Doberman");
		LookupTable lookup32 = new LookupTable ("Breed", "Boxer");
		LookupTable lookup33 = new LookupTable ("Breed", "Pitbulls");

		LookupTable lookup34 = new LookupTable ("Hairlength", "Bald");
		LookupTable lookup35 = new LookupTable ("Hairlength", "Short");
		LookupTable lookup36 = new LookupTable ("Hairlength", "Medium");
		LookupTable lookup37 = new LookupTable ("Hairlength", "Long");
		
		LookupTable lookup38 = new LookupTable ("Status", "Pending");
		LookupTable lookup39 = new LookupTable ("Status", "Approved");
		LookupTable lookup40 = new LookupTable ("Status", "Cancel");
		LookupTable lookup41 = new LookupTable ("Status", "Declined");
		
		LookupTable lookup42 = new LookupTable ("Species", "Gila Monster");
		LookupTable lookup43 = new LookupTable ("Species", "Goldfish");
		LookupTable lookup44 = new LookupTable ("Species", "Beta Fish");
		LookupTable lookup45 = new LookupTable ("Species", "Iguana");
		LookupTable lookup46 = new LookupTable ("Species", "Cuttlefish");
		LookupTable lookup47 = new LookupTable ("Species", "Octopus");
		LookupTable lookup48 = new LookupTable ("Species", "Angular Fish");
		
		LookupTable lookup49 = new LookupTable ("Water_Type", "Freshwater");
		LookupTable lookup50 = new LookupTable ("Water_Type", "Saltwater");
		
		s.save(lookup1);
		s.save(lookup2);
		s.save(lookup3);
		s.save(lookup4);
		s.save(lookup5);
		s.save(lookup6);
		s.save(lookup7);
		s.save(lookup8);
		s.save(lookup9);
		s.save(lookup10);
		s.save(lookup11);
		s.save(lookup12);
		s.save(lookup13);
		s.save(lookup14);
		s.save(lookup15);
		s.save(lookup16);
		s.save(lookup17);
		s.save(lookup18);
		s.save(lookup19);
		s.save(lookup20);
		s.save(lookup21);
		s.save(lookup22);
		s.save(lookup23);
		s.save(lookup24);
		s.save(lookup25);
		s.save(lookup26);
		s.save(lookup27);
		s.save(lookup28);
		s.save(lookup29);
		s.save(lookup30);
		s.save(lookup31);
		s.save(lookup32);
		s.save(lookup33);
		s.save(lookup34);
		s.save(lookup35);
		s.save(lookup36);
		s.save(lookup37);
		s.save(lookup38);
		s.save(lookup39);
		s.save(lookup40);
		s.save(lookup41);
		s.save(lookup42);
		s.save(lookup43);
		s.save(lookup44);
		s.save(lookup45);
		s.save(lookup46);
		s.save(lookup47);
		s.save(lookup48);
		s.save(lookup49);
		s.save(lookup50);
		
		tx.commit();
		s.close();
	}

	/*
	static void saveAndPersist(FlashcardDao fd) {
		System.out.println(
				fd.addFlashcard(new Flashcard("What version of Java do we use?", "Java 8", new Category(1, ""))));
	}

	static void getVsLoad(FlashcardDao fd) {
		Flashcard f4 = fd.getFlashcardById(4);

		// get vs load
		if (f4 != null) {
			System.out.println("flashcard 4 exists");
			// f4 is detached
			System.out.println(f4.getQuestion());
			// if Category is lazily fetched, line below throws exception
			// System.out.println(f4.getCategory());
		} else {
			System.out.println("flashcard 4 does not exist");
		}
	}

	static void updateAndMerge() {

		Flashcard f = new Flashcard("Where you stand if you're cold?", "In the corner, it's 90 degrees.",
				new Category(2, "")); // transient

		Session s1 = HibernateUtil.getSession();
		Transaction tx1 = s1.beginTransaction();
		int genId = (int) s1.save(f);
		tx1.commit();
		s1.close();

		// f is detached
		Session s2 = HibernateUtil.getSession();
		Transaction tx2 = s2.beginTransaction();
		try {

			Flashcard f2 = (Flashcard) s2.get(Flashcard.class, genId);
			// f2 is persistent and has same persistence identity (same id) as
			// detached object f
			f.setAnswer("The corner, it's 90 degrees"); // f is still detached
			// s2.update(f);
			// throws NonUniqueObjectException because update attempts to
			// reattach f to s2

			s2.merge(f); // this is fine

			tx2.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx2.rollback();
		}
		s2.close();
	}

	static void funWithNamedQueries(Category c) {

		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("findCardByCategory");
		q.setInteger("categoryVar", c.getId());
		List<Flashcard> cards = q.list();
		System.out.println(cards.size());
		Iterator<Flashcard> itr = cards.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		s.close();

	}

	static void funWithCriteria() {
		Session s = HibernateUtil.getSession();
		// STAY TUNED FOR BEARS
		s.close();

	}

	static void funWithCache() {
		Session s = HibernateUtil.getSession();

		Flashcard f = (Flashcard) s.load(Flashcard.class, 23);
		System.out.println(f.getQuestion());

		// s.evict(f); s.clear() also works for all cached data

		System.out.println(s.contains(f));

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
	
	static void testProjections()
	{
		BearDao bearDao = new BearDaoImpl();
		BatDao batDao = new BatDaoImpl();
		
		System.out.println(bearDao.countBears());
		//batDao.totalWingspan();
	}
	*/
}
