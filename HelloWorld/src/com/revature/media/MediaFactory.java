package com.revature.media;

public class MediaFactory {

	public Media getMedia(String type, String title, String creator, int yearPublished) {

		if(type.equalsIgnoreCase("BOOK")) {

			return new Book(creator, title, yearPublished, "Entertainment");

		}

		

		else if(type.equalsIgnoreCase("MOVIE")) {

			return new Movie(creator, title, yearPublished, "Entertainment");

		}

		else {

			return new Series(creator, title, yearPublished, "Entertainment", 5, 10);

		}

	}

}