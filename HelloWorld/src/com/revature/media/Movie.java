package com.revature.media;

public class Movie extends Media implements Comparable<Movie>{
	
	private int movieId;
	
	public void setMovieId(int id){
		this.movieId = id;
	}
	
	public int getMovieId(){
		return this.movieId;
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
	public int compareTo(Movie m) {
		return this.title.compareTo(m.getTitle());
	}

}
