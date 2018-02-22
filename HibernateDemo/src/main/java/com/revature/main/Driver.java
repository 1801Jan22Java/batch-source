package com.revature.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.domain.Category;
import com.revature.domain.Flashcard;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		init();
	}
	
	static void init(){
		
		
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Category c1 = new Category("coding");
		Category c2 = new Category("jokes");
		
		
		
		
		
		//create some flashcards to save
		Flashcard f1 = new Flashcard("What is Java?","The coolest language.",c1);
		Flashcard f2 = new Flashcard("Where are the bears?","Hibernating",c2);
		
		s.save(f1);
		s.save(f2);
		
		tx.commit();
		s.close();
		
	}
}