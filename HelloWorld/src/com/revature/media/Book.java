package com.revature.media;

public class Book extends Media {
	
	private String publisher;
	
	public Book(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}

	public Book() {
		super();
	}

	public void read() {
		System.out.println("reading " + this.getTitle() + " by " + this.getCreator());
	}

	@Override
	public String toString() {
		return "Book [publisher=" + publisher + "]";
	}
}
