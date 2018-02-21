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
		FlashcardDao fd = new FlashcardDaoImpl();

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Category c1 = new Category("coding");
		Category c2 = new Category("bears");
		
		s.save(c1);
		s.save(c2);

		// Create some flashcards
		Flashcard f1 = new Flashcard("What is java?", "The cruelist language", c1);
		Flashcard f2 = new Flashcard("WHere are the bears?", "Hibernating", c2);

		s.save(f1);
		s.save(f2);
		
//		fd.addFlashcard(f1);
//		fd.addFlashcard(f2);
		
		tx.commit();
		s.close();
	}

}
