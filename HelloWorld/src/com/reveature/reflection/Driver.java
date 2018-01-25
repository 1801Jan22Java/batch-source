package com.reveature.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;

public class Driver {
	public static void main(String[] args) {
		
		List<Media> mediaList = new ArrayList<>();
		Book b1 = new Book("Leo Tolstory", "Anna Karenia", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichon", "Jurassic Park", 1993, "science fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);
		System.out.println(genericReflection(mediaList));
		Collections.shuffle(mediaList);
		System.out.println(genericReflection(mediaList));
		
	}
	
	public static <T> T genericReflection(List<T> list) {
		for (T item : list) {
			if (item.getClass().getName().equals("com.revature.media.Book")) {
				return item;
			}
		}
		return null;
	}
	public static void funWithReflection() {

		try {
			
			//get our class
			Class clazz = Class.forName("com.revature.media.Media");
			System.out.println(clazz.getName());
			
			//print fields
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field f : fields) {
				System.out.println(f.getName() + " with a datatype of " + f.getType());
			}
			
			//new instance of book
			Class clazz2 = Class.forName("com.revature.media.Book");
			Book b1 = (Book) clazz2.newInstance();
			System.out.println(b1);
			
			Field publisher = clazz2.getDeclaredField("publisher");
			publisher.setAccessible(true);
			publisher.set(b1, "Michael Bay");
			System.out.println(b1);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
	}
}
