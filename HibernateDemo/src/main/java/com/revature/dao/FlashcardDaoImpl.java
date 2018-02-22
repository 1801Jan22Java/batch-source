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
		for (Flashcard f : flashcards){
			System.out.println(f);
		}
		s.close();
		return flashcards;
	}

	@Override
	public Flashcard getFlashcardById(int id) {
		Session s = HibernateUtil.getSession();
		Flashcard f = (Flashcard) s.get(Flashcard.class, id); //what if it was load???
		s.close();
		return f;
	}

	@Override
	public int addFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		//int result = (int) s.save(f); //save returns the generated Id
		int result = 0;
		s.persist(f);
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
