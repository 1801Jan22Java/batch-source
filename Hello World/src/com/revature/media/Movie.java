package com.revature.media;

public class Movie extends Media implements Comparable<Movie>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2488253115292646972L;

	public Movie() {
		super();
		
	}

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}

	public void watch() {
		System.out.println("Get your popcorn! We're watching " + this.getTitle());
	}

	@Override
	public int compareTo(Movie arg0) {
		
		return this.title.compareTo(arg0.getTitle());
			
	}
	
}
