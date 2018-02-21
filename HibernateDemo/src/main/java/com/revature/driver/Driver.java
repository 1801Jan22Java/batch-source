package com.revature.driver;

import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOImpl;
import com.revature.domain.Flashcard;

public class Driver {
	
	public static void main(String[] args) {

	}
	
	static void init() {
		FlashcardDAO fd = new FlashcardDAOImpl();
		fd.getFlashcards();
		
		// create some flashcards to save
		Flashcard f1 = new Flashcard("What is Java?", "The coolest language.");
		Flashcard f2 = new Flashcard("Where are the bears?", "Hibernating");
		
		fd.addFlashcard(f1);
		fd.addFlashcard(f2);
		
	}
}
