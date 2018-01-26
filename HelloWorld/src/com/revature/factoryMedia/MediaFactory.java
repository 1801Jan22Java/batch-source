package com.revature.factoryMedia;

public class MediaFactory {
	public Media testFactory(String type, String title, String creator, int yearPublished) {
		if(type == null) {
			return null;
		}
		
		if(type.equalsIgnoreCase("MOVIE")) {
			Movie m = new Movie(title, creator, yearPublished);
			return m;
		}
		
		else if(type.equalsIgnoreCase("BOOK")) {
			return new Book(title, creator, yearPublished);
		}
		
		return null;
	}
}
