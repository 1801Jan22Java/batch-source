package com.revature.collections;

import java.io.Serializable;

public class Book extends Media implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5162496723850485691L;
	private String publisher;	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	public void read()
	{
		System.out.println("reading "+this.getTitle()+" "+this.getYearPublished()+" by "+this.getCreator());
	}
	@Override
	public String toString()
	{
		return "Name: "+this.getTitle()+"Publisher: "+this.getCreator();
	}
}
