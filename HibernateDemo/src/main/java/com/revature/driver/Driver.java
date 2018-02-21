package com.revature.driver;

import com.revature.dao.*;

public class Driver {

	
	public static void main(String[] args) {
		FlashcardDao fd = new FlashcardDaoImpl();
		fd.getFlashcards();
	}

}
