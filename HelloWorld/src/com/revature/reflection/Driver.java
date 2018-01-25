package com.revature.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class Driver {

	public static void main(String[] args) {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishmeht", 1866, "Fiction");

		Movie m1 = new Movie("Toy Story", "Pixar", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993, "Science Fiction");
		
		
		Collections.addAll(mediaList, b1, b2, m1, m2);
		System.out.println(genericReflections(mediaList));
		Collections.shuffle(mediaList);
		System.out.println(genericReflections(mediaList));
		
	}
	
	public static <T> T genericReflections(List<T> l) {
		for (T item : l) {
			if(item.getClass().getName().equals("com.revature.media.Book")){
				return item;
			}
		}
		return null;
	}
	
	public static void funWithReflection() {
		try {
			// Checked exception. Raw string input could lead to a nonexistent fully qualified class name
			// Get our class
			Class clazz = Class.forName("com.revature.media.Media");
			System.out.println(clazz.getSimpleName());
			
			// Print our fields
			Field[] fields = clazz.getDeclaredFields();
			
			// We can actually see all of the field types despite them being protected or private
			// We haven't even imported Media
			for (Field f : fields) {
				System.out.println(f.getName() + " with a datatype of " + f.getType());
			}
			
			// New instance of Book - need to actually import Book
			Class clazz2 = Class.forName("com.revature.media.Book");
			Book b1 = (Book) clazz2.newInstance();
			System.out.println(b1);
			Field publisher = clazz2.getDeclaredField("publisher");
			publisher.setAccessible(true);
			publisher.set(b1,  "Michael Bay");
			System.out.println(b1);
			
			//Can get declared methods and invoke them, too. Spooky!
			
		} catch (ClassNotFoundException |
				InstantiationException | 
				IllegalAccessException | 
				NoSuchFieldException | 
				SecurityException e) {
			e.printStackTrace();
		}

	}

}
