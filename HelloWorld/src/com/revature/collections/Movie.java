package com.revature.collections;

import com.revature.media.Media;

public class Movie extends Media implements Comparable<Movie>{
	
	public void watch() {
		System.out.println("watching "+this.getTitle());
	}

	public Movie() {
		super();
	}

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}

	@Override
	public int compareTo(Movie m) {
		
		return this.title.compareTo(m.title);
	}
	
	
}
