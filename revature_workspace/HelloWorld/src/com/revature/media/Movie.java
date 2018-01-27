package com.revature.media;

public class Movie extends Media implements Comparable <Movie> {
	
	private int movieID;
	
	public void setMovieID(int id)
	{
		this.movieID=id;
	}
	
	
	public int getMovieID ()
	{
		return movieID;
	}
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	public void watch()
	{
		System.out.println("Get your Swedish fish, we're watching " + this.getTitle());
	}

	@Override
	public int compareTo(Movie m) {
		
		return this.title.compareTo(m.getTitle());
	}
	
	
	

}
