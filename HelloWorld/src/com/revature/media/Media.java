package com.revature.media;

public abstract class Media {
	
	protected String creator;
	protected String title;
	protected int yearPublished;
	protected String genre;
	
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Media(String creator, String title, int yearPublished, String genre) {
		super();
		this.creator = creator;
		this.title = title;
		this.yearPublished = yearPublished;
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
}
