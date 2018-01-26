package com.revature.media;

import java.io.Serializable;

public class Book extends Media implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1935367765088492580L;

	public Book() {
		super();
		
	}

	public Book(String creator, String title, int yearPublished, String genre, String publisher) {
		super(creator, title, yearPublished, genre);
		this.publisher = publisher;
		
	}

	private String publisher;
	
	public void read() {
		System.out.println("reading " + this.getTitle() + " by " + this.getCreator());
	}

	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + ", getCreator()=" + getCreator() + ", getTitle()=" + getTitle()
				+ ", getYearPublished()=" + getYearPublished() + ", getGenre()=" + getGenre() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
