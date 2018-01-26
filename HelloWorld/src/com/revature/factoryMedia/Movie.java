package com.revature.factoryMedia;

public class Movie implements Media {
	public Movie(String title, String creator, int yearPublished) {
		super();
		this.title = title;
		this.creator = creator;
		this.yearPublished = yearPublished;
	}

	private String title;
	private String creator;
	private int yearPublished;

	public void consumeMedia() {
		System.out.println("This is a movie: " + title + " by " + creator + ", probably not released in " + yearPublished);
	}
}
