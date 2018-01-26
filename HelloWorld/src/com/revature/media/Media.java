package com.revature.media;

public abstract class Media {
	
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Media(String creator, String title, int yearPublished, String genre) {
		super();
		this.publisher = creator;
		this.title = title;
		this.yearPublished = yearPublished;
		this.genre = genre;
	}
	protected String publisher;
	protected String title;
	protected int yearPublished;
	protected String genre;
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String creator) {
		this.publisher = creator;
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
	@Override
	public String toString() {
		return "Media [creator=" + publisher + ", title=" + title + ", yearPublished=" + yearPublished + ", genre="
				+ genre + "]";
	}
	
}
