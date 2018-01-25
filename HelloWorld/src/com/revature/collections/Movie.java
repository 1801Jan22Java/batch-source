package com.revature.collections;

public class Movie extends Media {

	
	
	
	public Movie() {
		super();
	}
	
	

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}



	public void watch() {
		System.out.println("get your popcorn! we're watching " + this.getTitle());
	}
	
}
