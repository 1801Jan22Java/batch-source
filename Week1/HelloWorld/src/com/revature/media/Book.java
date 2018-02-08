package com.revature.media;

import java.io.Serializable;

public class Book extends Media implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7772510483878841387L;
	protected String publisher;
	public Book(String creator, String title, int yearPublished, String genre, String publisher) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
		this.publisher = publisher;
	}
	
	public void read()
	{
		System.out.println("Reading " + title + " by " + creator);
	}
	
}
