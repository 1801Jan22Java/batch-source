package com.revature.media;



public class MediaFactoryDriver {



	public static void main(String[] args) {

		

		System.out.println("Creating Media Factory");

		MediaFactory factory = new MediaFactory();

		Book b1 = (Book) factory.getMedia("BOOK", "Cat's Cradle ",  "Kurt Vonnegut ",  1963);

		System.out.println("Got book " + b1.toString());

		Movie m1 = (Movie) factory.getMedia("MOVIE",  "Eye in the Sky ",  "Gavin Hood ", 2015);

		System.out.println("Got movie " + m1.toString());

		Series s1 = (Series) factory.getMedia("SERIES",  "Black Mirror ",  "Charlie Brooker ", 2011);

		System.out.println("Got series " + s1.toString());

	}



}