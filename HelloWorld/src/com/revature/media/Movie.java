package com.revature.media;

public class Movie extends Media implements Comparable<Movie>{
	
	private int movieId;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}
	
	public void watch() {
		System.out.println("Get your popcorn! We're watching " + this.getTitle() + " by " + this.getCreator());
	}

	@Override
	public int compareTo(Movie m) {
		return this.getTitle().compareTo(m.getTitle());
	}

	
	//Getters and Setters
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}
	
	
}
