package com.revature.driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.dao.FlashcardDao;
import com.revature.dao.FlashcardDaoImpl;
import com.revature.domain.Animal;
import com.revature.domain.Bat;
import com.revature.domain.Bear;
import com.revature.domain.Category;
import com.revature.domain.Cave;
import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		// init();

		// FlashcardDao fd = new FlashcardDaoImpl();

		// saveAndPersist(fd);

		// fd.getFlashcards();

		// updateAndMerge();

		// Category c1 = new Category (1, "coding");
		// funWithNamedQueries(c1);

		// funWithCache();

		// animalInit();

		moreAnimals();

	}

	static void init() {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		Category c1 = new Category("coding");
		Category c2 = new Category("jokes");

		// create some flashcards to save
		Flashcard f1 = new Flashcard("What is Java?", "The coolest language.", c1);
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating", c2);
		Flashcard f3 = new Flashcard("What did the DBA tell his inebriated friend?", "You had one-to-many.", c2);

		s.save(f1);
		s.save(f2);
		s.saveOrUpdate(f3);

		tx.commit();
		s.close();

	}

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
}
