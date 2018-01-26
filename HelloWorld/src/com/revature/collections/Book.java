package com.revature.collections;

import java.io.Serializable;

import com.revature.media.Media;

public class Book extends Media implements Serializable{
	
	private String publisher;
	
	
	public Book() {
		super();
	}



	public Book(String creator, String title, int yearPublished, String genre) {
		super(creator, title, yearPublished, genre);
	}



	public Book(String publisher) {
		super();
		this.setPublisher(publisher);
	}



	public void read() {
		System.out.println("reading "+this.getTitle()+" by "+this.getCreator());
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}




	
	
	
}
