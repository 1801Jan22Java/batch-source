package com.revature.media;

public class Movie extends Media implements Comparable<Movie> {

	private int movieId;
	
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}



	public int getMovieId() {
		return movieId;
	}



	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}



	public Movie() {
		super();
	}
	
	

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}



	public void watch() {
		System.out.println("get your popcorn! we're watching " + this.getTitle());
	}





	@Override
	public int compareTo(Movie arg0) {
		
		return this.title.compareTo(arg0.getTitle());
	}
	
}
