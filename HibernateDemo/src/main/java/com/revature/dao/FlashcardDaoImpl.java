package com.revature.dao;

import java.util.List;

import org.hibernate.*;

import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao{

	@Override
	public List<Flashcard> getFlashcards() {
		Session s = HibernateUtil.getSession();
		
		//SELECT everything FROM the FLASHCARD table
		//Flashcard refers to the name of the Java object that's mapped to a table in your database
		List<Flashcard> flashcards = s.createQuery("from Flashcard").list();
		for (Flashcard f : flashcards) {
			System.out.println(f);
		}
		s.close();
		return flashcards;
	}

	@Override
	public Flashcard getFlashcardById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		
		//org.hibernate
		Transaction tx = s.beginTransaction();

		//We'll be using our save() method
		//save() returns the generated ID
		int result = (int)s.save(f);
		
		tx.commit();
		s.close();
		
		return result;
	}

	@Override
	public void updateFlashcard(Flashcard f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFlashcard(Flashcard f) {
		// TODO Auto-generated method stub
		
	}
	
}
