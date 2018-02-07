package com.revature.media;

public class Movie extends Media implements Comparable<Movie>{
	
	private int movieID;
	
	public void setMovieId(int id) {
		this.movieID = id;
	}
	
	public int getMovieId() {
		return this.movieID;
	}
	
	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}

	public Movie() {
		super();
	}

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}

	public void watch() {
		System.out.println("Get your popcorn! We're watching " + this.title);
	}

	@Override
	public int compareTo(Movie m) {
		return this.title.compareTo(m.getTitle());
	}
}
