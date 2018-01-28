package com.revature.collections;

public class Movie extends Media implements Comparable<Movie> {


	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Movie m) {
		return this.title.compareTo(m.getTitle());
	}
	
}
