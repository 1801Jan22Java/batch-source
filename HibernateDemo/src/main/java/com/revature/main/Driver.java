package com.revature.main;

import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOImpl;
import com.revature.domain.Category;
import com.revature.domain.Flashcard;

public class Driver {
	public static void main(String[] args) {
		init();
	}
	static void init() {
		FlashcardDAO fd = new FlashcardDAOImpl();
		
		
		Category c1 = new Category("coding");
		
		//create some flashcards to save
		Flashcard f1 = new Flashcard("What is java?", "the coolest language", c1);
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating", c1);
		
		fd.addFlashCard(f1);
		fd.addFlashCard(f2);
		fd.getFlashcards();
	}
	
	
}
