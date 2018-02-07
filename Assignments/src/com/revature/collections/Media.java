package com.revature.collections;

import java.io.Serializable;

public abstract class Media implements Serializable{

	protected int yearPublished;
	protected transient String genre;
	protected String creator;
	protected String title;
	
	
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Media(int yearPublished, String genre, String creator, String title) {
		super();
		this.yearPublished = yearPublished;
		this.genre = genre;
		this.creator = creator;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Media [yearPublished=" + yearPublished + ", genre=" + genre + ", creator=" + creator + ", title="
				+ title + "]";
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

	
}
