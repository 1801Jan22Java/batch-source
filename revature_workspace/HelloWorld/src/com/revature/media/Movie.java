package com.revature.media;

public class Movie extends Media {
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	public void watch()
	{
		System.out.println("Get your Swedish fish, we're watching " + this.getTitle());
	}

}
