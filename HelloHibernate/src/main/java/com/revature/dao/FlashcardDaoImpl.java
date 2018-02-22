package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao {

	@Override
	public List<Flashcard> getFlashCards() {
		Session s = HibernateUtil.getSession();
		List<Flashcard> flashcards = s.createQuery("from Flashcard").list();
		for (Flashcard f : flashcards) {
			System.out.println(f);
		}
		s.close();
		return flashcards;
	}

	@Override
	public Flashcard getFlashcardById(int id) {
		return null;
	}

	@Override
	public int addFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(f); // save returns the generated id
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateFlashcard(Flashcard f) {

	}

	@Override
	public void deleteFlashcard(Flashcard f) {

	}

}
