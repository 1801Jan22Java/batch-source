package com.revature.collections;

import java.io.Serializable;

public class Book extends Media implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1775256641448787579L;
	private String publisher;
	
	public void read() {
		System.out.println("reading "+this.getTitle()+" by "+this.getCreator());
	}

	public Book(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}

	public Book(String publisher, String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}

}
