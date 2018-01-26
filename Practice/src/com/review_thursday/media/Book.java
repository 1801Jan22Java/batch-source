package com.review_thursday.media;

public class Book extends Media {
	private String publisher; 
	
	public Book() {
		super();
	}
	
	public Book(String creator,String title, int yearPublished,String genre) {
		super(creator,title,yearPublished,genre);
	}
	public Book(String publisher,String creator,String title, int yearPublished,String genre) {
		super(creator,title,yearPublished,genre);
		this.publisher = publisher;
	}
	public void read() {
		System.out.println("reading "+this.getTitle()+" by "+this.getCreator());
	}

	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", creator=" + creator + ", title=" + title + ", yearPublished="
				+ yearPublished + ", genre=" + genre + "]";
	}
	
	

}
