package com.revature.collections;

public class Book extends Media {

	
	
	
	
	
	

	public Book() {
		super();
		
	}

	public Book(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}

	public void read() {
		System.out.println("reading " + this.getTitle() + " by " + this.getCreator());
	}
	
}
