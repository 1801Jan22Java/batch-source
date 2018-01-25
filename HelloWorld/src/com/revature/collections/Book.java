package com.revature.collections;

import com.revature.media.Media;

public class Book extends Media{
	
	private String publisher;
	
	
	
	public Book() {
		super();
	}



	public Book(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}



	public Book(String publisher) {
		super();
		this.publisher = publisher;
	}



	public void read() {
		System.out.println("reading "+this.getTitle()+" by"+this.getCreator());
	}
	
}
