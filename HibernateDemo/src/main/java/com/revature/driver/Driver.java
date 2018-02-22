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
		init();
	}
	
	static void init() {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		FlashcardDao fd = new FlashcardDaoImpl();
		fd.getFlashcards();
		
		Category c1 = new Category("coding");
		
		s.save(c1);
		
		
		// create some flashcards to save
		Flashcard f1 = new Flashcard("What is Java?", "The coolest language", c1);
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating", c1);
		
		fd.addFlashcard(f1);
		fd.addFlashcard(f2);
		
		s.save(f1);
		s.save(f2);
	}

}
