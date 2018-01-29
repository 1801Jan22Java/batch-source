package com.revature.collections;

import java.io.Serializable;

public abstract class Media implements Serializable
{
	//by setting this field as transient, it makes the item unserializable, so when it reads from this object
	//it won't be able to see it
	protected transient String creator;
	protected String title;
	protected int yearPublished;
	public String genre;
	
	private static final long serialVersionUID = -5112831459235079037L;
	public Media(String creator, String title, int yearPublished, String genre) {
		super();
		this.creator = creator;
		this.title = title;
		this.yearPublished = yearPublished;
		this.genre = genre;
	}
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		return 0;
	}
}
