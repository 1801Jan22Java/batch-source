package com.revature.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import com.revature.media.Book;
import com.revature.media.Media;
import com.revature.media.Movie;


public class Driver {

	public static <T> T genericReflections(List<T> l)
	{
		for(T item : l)
		{
			if(item.getClass().getName().equals("com.revature.media.Book"))
			{
				return item;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Leo Tolstoy", "Anna Karenina", 1877, "Fiction");
		Book b2 = new Book("Fyodor Dostoevsky", "Crime and Punishment", 1866,
				"Fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "Cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurassic Park", 1993,
				"science fiction");
		Collections.addAll(mediaList, b1, b2, m1, m2);
		Collections.shuffle(mediaList);
		System.out.println(genericReflections(mediaList));

		
		//Throws ClassNotFoundException (checked exception)
		try{
		//The Class class is often used for reflection
		Class clazz = Class.forName("com.revature.media.Media");
		System.out.println(clazz.getSimpleName());
		Field[] field = clazz.getDeclaredFields();
		for(Field f: field)
		{
			System.out.println(f.getName()+  " with a data type of "+ f.getType());
		}
		//New instance of Book
		Class clazz2 = Class.forName("com.revature.media.Book");
		try{
		Book b5 = (Book) clazz2.newInstance();
		System.out.println(b5);
		Field publisher = clazz.getDeclaredField("publisher");
		publisher.setAccessible(true);
		publisher.set(b5,"Michael Bay");
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch(InstantiationException e2)
		{
			e2.printStackTrace();
		}
		catch(NoSuchFieldException e3)
		{
			e3.printStackTrace();
			
		}
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			
		}
		

	}
	
	

}