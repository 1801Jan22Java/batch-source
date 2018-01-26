package com.revature.collections;

public class Book extends Media{

	private String publisher;
	
	public void read()
	{
		System.out.println("reading " + this.getTitle());
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
