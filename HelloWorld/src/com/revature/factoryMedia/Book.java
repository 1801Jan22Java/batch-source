package com.revature.factoryMedia;

public class Book implements Media {
	public Book(String title2, String creator2, int yearPublished) {
		super();
		this.title = title2;
		this.creator = creator2;
		this.yearPublished = yearPublished;
	}

	private String title;
	private String creator;
	private int yearPublished;
	
	public void consumeMedia() {
		System.out.println("This is a book: " + title + " by " + creator + ", probably not released in " + yearPublished);
	}
}
