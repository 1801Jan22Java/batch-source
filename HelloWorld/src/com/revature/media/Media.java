package com.revature.media;

<<<<<<< HEAD
import java.beans.Transient;
import java.io.Serializable;

public abstract class Media implements Serializable{
	
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
	public int getYearPublished() {
		return yearPublished;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
=======
import java.io.Serializable;

public abstract class Media implements Serializable {

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
	protected String creator;
	protected String title;
	protected int yearPublished;
	protected transient String genre;
	public String getCreator() {
		return creator;
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
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	@Override
	public String toString() {
		return "Media [creator=" + creator + ", title=" + title + ", yearPublished=" + yearPublished + ", genre="
				+ genre + "]";
	}
<<<<<<< HEAD
	
	

	
=======

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
