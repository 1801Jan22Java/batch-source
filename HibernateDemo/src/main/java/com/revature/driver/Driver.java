package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.domain.Category;
import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class Driver {

	
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();		//import org.hibernate.Transaction;
		
		//FlashcardDao fd = new FlashcardDaoImpl();
		//fd.getFlashcards();
		
		//Create some categories
		Category c1 = new Category("Coding");
		
		s.save(c1);
		
		//Create some flashcards to save
		Flashcard f1 = new Flashcard("What is Java?", "The coolest language.", c1);
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating.", c1);
		 
		//fd.addFlashcard(f1);
		//fd.addFlashcard(f2);
		
		s.save(f1);
		s.save(f2);
		
		tx.commit();
		s.close();
		
		
	}

}
