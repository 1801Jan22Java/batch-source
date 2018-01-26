package com.revature.media;

import java.io.Serializable;

public class Book extends Media implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1935367765088492580L;
	private String publisher;
	
	public Book() {
		super();
	}

	public Book(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}

	public void read(){
		System.out.println("reading "+this.getTitle()+" by "+this.getCreator());
	}

	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}

}
