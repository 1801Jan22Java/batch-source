package com.review_thursday.media;

public class Movie extends Media implements Comparable<Movie> {
	public Movie() {
		super();
	}

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}
	
	public void watch() {
		System.out.println("get your popcorn! we're watchint "+ this.getTitle());
	}
	
	@Override
	public int compareTo(Movie m) {
		return this.getTitle().compareTo(m.getTitle());
	}
	
	
	
}
