package com.revature.collections;

public abstract class Media {

	protected String creator;
	protected String title;
	protected String yearPublished;
	protected String genre;
	
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the yearPublished
	 */
	public String getYearPublished() {
		return yearPublished;
	}

	/**
	 * @param yearPublished the yearPublished to set
	 */
	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
