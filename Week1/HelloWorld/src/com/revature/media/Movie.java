package com.revature.media;

public class Movie extends Media implements Comparable<Movie>
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3889564453881496730L;
	//field created during serializable demo
	private int movieId;
	
	public int getID()
	{
		return movieId;
	}
	
	//method created during serializable demo
	public void setMovieID(int id)
	{
		movieId = id;
	}
	
	public Movie()
	{
		super();
	}
	
	public Movie(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
		// TODO Auto-generated constructor stub
	}

	public void watch()
	{
		System.out.println("Watching " + title + "directed by " + creator);
	}

	@Override
	public int compareTo(Movie m) {
		return this.title.compareTo(m.getTitle());
	}
}
