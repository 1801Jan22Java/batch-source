package com.revature.factoryMedia;

public class Driver {
	public static void main(String[] args) {
		MediaFactory mf = new MediaFactory();
		
		//title, creator, yearpublished
		String title = "Harry Potter and the Goblet of Fire";
		String creator = "J. K. Rowling";
		int yearPublished = 1900;
		
		Media m1 = mf.testFactory("MOVIE", title, creator, yearPublished);
		
		m1.consumeMedia();
		
		Media m2 = mf.testFactory("BOOK", title, creator, yearPublished);
		
		m2.consumeMedia();
	}
}
