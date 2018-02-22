package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.FlashcardDao;
import com.revature.dao.FlashcardDaoImpl;
import com.revature.domain.Category;
import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		// init();

		// FlashcardDao fd = new FlashcardDaoImpl();

		// saveAndPersist(fd);

		//  fd.getFlashcards();
		
		updateAndMerge();

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

	void getVsLoad(FlashcardDao fd) {
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
		
		//f is detached
		Session s2 = HibernateUtil.getSession();
		Transaction tx2 = s2.beginTransaction();
		try {
			
			Flashcard f2 = (Flashcard) s2.get(Flashcard.class, genId);
			//f2 is persistent and has same persistence identity (same id) as 
			//detached object f
			f.setAnswer("The corner, it's 90 degrees"); //f is still detached
			//s2.update(f); 
			//throws NonUniqueObjectException because update attempts to reattach f to s2 
			
			s2.merge(f); //this is fine 
			
			tx2.commit();
		} catch (Exception e){
			e.printStackTrace();
			tx2.rollback();
		}
		s2.close();
	}
}