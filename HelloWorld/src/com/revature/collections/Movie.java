package com.revature.collections;

import com.revature.media.Media;

public class Movie extends Media implements Comparable<Movie> {

	private int movieId;

	public void setMovieId(int id) {
		this.movieId = id;
	}
	
	public int getMovieId() {
		return this.movieId;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}

	public void watch() {
		System.out.println("watching " + this.getTitle());
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
