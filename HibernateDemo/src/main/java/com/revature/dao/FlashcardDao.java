package com.revature.dao;

import com.revature.domain.*;
import java.util.*;

public interface FlashcardDao {
	public List<Flashcard> getFlashcards();
	public Flashcard getFlashcardById(int id);
	public int addFlashcard(Flashcard f);
	public void updateFlashcard(Flashcard f);
	public void deleteFlashcard(Flashcard f);
}
