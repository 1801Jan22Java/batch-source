package com.revature.reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.collections.Book;
import com.revature.collections.Media;
import com.revature.collections.Movie;

public class Driver 
{

	public static void main(String[] args) throws ClassNotFoundException 
	{
		// Books
				Book b1 = new Book("Leo Tolstoy", "Anna Karenia", 1877, "fiction");
				Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
				// Movies
				Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
				Movie m2 = new Movie("Michael Crichton", "Jurrassic Park", 1993, "Science Fiction");
				List<Media> mediaList = new ArrayList<Media>();
				Collections.addAll(mediaList,m1,m2);
	}
	public static <T>T genericReflections(List<T>l)
	{
		for(T item: l)
		{
			if(item.getClass().getName().equals("com.revature.collections.Book"))
			{
				return item;
			}
		}
		return null;
	}
	public void funWithReflections()
	{
		//Must throw a ClassNotFoundException because user input it used to look for a class that might not work
				try 
				{
					//get our class
					Class clazz = Class.forName("com.revature.collections.Media");
					System.out.println(clazz.getName());
					//print our fields
					Field[] fields = clazz.getDeclaredFields();
					for(Field f: fields)
					{
						System.out.println(f);
					}
					//new instances of Book
					Class clazz2 = Class.forName("com.revature.collections.Book");
					Book b1 = (Book) clazz2.newInstance();
					System.out.println(b1);
					Field publisher = clazz2.getDeclaredField("publisher");
					publisher.setAccessible(true);
					publisher.set(b1, "Mochael Bay");
					System.out.println(b1);
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
