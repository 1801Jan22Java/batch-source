package com.revature.media;

import java.io.Serializable;

public abstract class Media implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1001379537371566478L;


	public Media(String creator, String title, int yearPublished, String genre) {
		super();
		this.creator = creator;
		this.title = title;
		this.yearPublished = yearPublished;
		this.genre = genre;
	}
	public Media() {
		super();
		
	}
	protected String creator;
	protected String title;
	protected int yearPublished;
	protected transient String genre;
	
	
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
	@Override
	public String toString() {
		return "Media [creator=" + creator + ", title=" + title + ", yearPublished=" + yearPublished + ", genre="
				+ genre + "]";
	}
}
