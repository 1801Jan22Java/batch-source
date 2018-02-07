package com.revature.collections;

public class Movie extends Media implements Comparable<Movie>{
	
	private int movieID;
	
	public void setMovieID(int id) {
		this.movieID = id;
	}
	
	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", yearPublished=" + yearPublished + ", genre=" + genre + ", creator="
				+ creator + ", title=" + title + "]";
	}

	public void watch() {
		System.out.println("get popcorn for watching " + this.getTitle());
	}

	public Movie() {
		super();
		
	}

	public Movie(int yearPublished, String genre, String creator, String title) {
		super(yearPublished, genre, creator, title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		return this.title.compareTo(m.getTitle());
	}

	
}
