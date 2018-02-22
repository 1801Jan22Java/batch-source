package com.revature.driver;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.revature.dao.*;
import com.revature.domain.Category;
import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class Driver {
	
	public static void main(String... args) {
		init();
	}
	
	static void init() {
		FlashcardDao fd = new FlashcardDaoImpl();
		
		Session s = HibernateUtil.getSession();
		Transaction tx = (Transaction) s.beginTransaction();
		
		Category c1 = new Category("coding");
		
		s.save(c1);
		
		Flashcard f1 = new Flashcard("What is java?", "The coolest language", c1);
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating", c1);
		
		fd.addFlashcard(f1);
		fd.addFlashcard(f2);
		
		try {
			tx.commit();
		} catch (SecurityException | RollbackException | HeuristicMixedException | HeuristicRollbackException
				| SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.close();
	}
	
}
