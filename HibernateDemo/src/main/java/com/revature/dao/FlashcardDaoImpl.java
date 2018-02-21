package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao {

	@Override
	public List<Flashcard> getFlashcards() {
		Session s = HibernateUtil.getSession();
		List<Flashcard> flashcards = s.createQuery("from Flashcard").list();
		for(Flashcard f : flashcards) {
			System.out.println(f);
		}
		s.close();
		return null;
	}

	@Override
	public Flashcard getFlashcardById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		
		// org.hibernate transaction
		Transaction tx = s.beginTransaction();
		
		// Returns the generated id
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
