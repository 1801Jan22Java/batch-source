package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.domain.Category;
import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class Driver {

	
	public static void main(String[] args) {
		//init();
		
		FlashcardDao fd = new FlashcardDaoImpl();
		//If we comment out the transaction and commit statements, this will still work
		
		//Save is less controllable, and it may or may not actually save your changes
		//if it is not in a transaction.
		//saveAndPersist(fd);
		
		updateAndMerge(fd);
	}
		
	public void getVsLoad() {
		
		//Get vs Load
		FlashcardDao fd = new FlashcardDaoImpl();
		Flashcard f3 = fd.getFlashcardById(3);
		
		if(f3 != null) {
			System.out.println("Flashcard 3 exists!");
			System.out.println(f3);
			//If Category is lazily fetched, the line below throws an exception
			//System.out.println(f3.getCategory());
		} else {
			System.out.println("Flashcard 3 does not exist. :(");
		}
	}
	
	static void saveAndPersist(FlashcardDao fd) {
		System.out.println(fd.addFlashcard(new Flashcard("What version of Java do we use?", "Java 8", new Category(1, ""))));
	}
	
	static void updateAndMerge(FlashcardDao fd) {
		Flashcard f1 = new Flashcard("Where should you stand if you're cold?",
						"In the corner, because it's 90 degrees", new Category(2, "")); //Transient object
		Session s1 = HibernateUtil.getSession();
		Transaction tx1 = s1.beginTransaction();
		
		int genId = (int) s1.save(f1);
		
		tx1.commit();
		s1.close();
		
		//f1 is detached. It was part of a persistence context (when it was saved),
		//but is no longer (since the session closed).
		Session s2 = HibernateUtil.getSession();
		Transaction tx2 = s2.beginTransaction();
		try {
			Flashcard f2 = (Flashcard) s2.get(Flashcard.class, genId);
			//f2 is persistent and has the same persistence identity (same id) as the detached object f1
			
			f1.setAnswer("The corner, it's 90 degrees.");
			//f1 is still detached. We haven't called a method that brings it from
			//transient to persistent.
			
			//s2.update(f1);
			//In this case, we'll get a NonUniqueObjectException if we use update()
			//Made a duplicate object and tried to update the original one.
			//Update attempts to reattach our object to s2. Doesn't check whether anything in s2
			//already has that identifier.
			//If you comment out f2's instantiation, you can call s2.update(f1);
			
			s2.merge(f1);	//This is fine
			
			tx2.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx2.rollback();
		}
		s2.close();
	}
	
	static void init() {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();		//import org.hibernate.Transaction;
		
		//FlashcardDao fd = new FlashcardDaoImpl();
		//fd.getFlashcards();
		
		//Create some categories
		Category c1 = new Category("Coding");
		Category c2 = new Category("Jokes");
		
		//Casting because we can potentially get something that isn't an int as a Primary Key
		//int newCategory1 = (int) s.save(c1);
		//int newCategory2 = (int) s.save(c2);
		
		//Create some flashcards to save
		//Category inserted first by Hibernate, since Flashcard depends on Category
		Flashcard f1 = new Flashcard("What is Java?", "The coolest language.", c1/*new Category(newCategory1, "Coding")*/);
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating.", c2/*new Category(newCategory1, "Coding")*/);
		Flashcard f3 = new Flashcard("What did the DBA tell his inebriated friend?", "You had one-to-many", c2);
		
		//fd.addFlashcard(f1);
		//fd.addFlashcard(f2);
		
		s.save(f1);
		s.save(f2);
		s.saveOrUpdate(f3);
		
		tx.commit();
		s.close();
		
		
	}

}
