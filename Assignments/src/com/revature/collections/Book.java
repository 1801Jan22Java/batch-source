package com.revature.collections;

import java.io.Serializable;

public class Book extends Media implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1810576434279795077L;
	private String publisher;
	
	
	
	public void read() {
		System.out.println("reading " + this.title + " by " + this.getCreator());
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int yearPublished, String genre, String creator, String title) {
		super(yearPublished, genre, creator, title);
		// TODO Auto-generated constructor stub
	}


	

	
}
