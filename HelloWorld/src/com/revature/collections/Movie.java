package com.revature.collections;

public class Movie extends Media implements Comparable<Movie>
{
	private int movieId;
	public void setMovieId(int id)
	{
		this.movieId = id;
	}
	public int getMovieId()
	{
		return this.movieId;
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
		System.out.println("Get your popcorn! you're watching "+this.getTitle());
	}
	@Override
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		return this.title.compareTo(m.getTitle());
	}
	@Override
	public String toString()
	{
		return "Name: "+this.getTitle()+" Publisher: "+this.getCreator()+" movieId: "+this.getMovieId();
	}
}
