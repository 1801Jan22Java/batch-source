package com.revature.functionalinterfaces;

import java.util.function.Predicate;

import com.revature.collections.Book;
import com.revature.collections.Media;
import com.revature.collections.Movie;

public class predicate 
{
	public static void main(String[] args)
    {
        // Creating predicate
        Predicate<Integer> lesserThan = i -> (i < 18);
        Predicate<Integer> greaterThan = i -> (i > 10 );
 
        // Calling Predicate method
        System.out.println(lesserThan.test(20)); 
        lesserThan.and(greaterThan);
        System.out.println(lesserThan.test(15));
        
        Book b1 = new Book("Leo Tolstoy", "Anna Karenia", 1877, "fiction");
		Book b2 = new Book("Fyodor Dostoyevsky", "Crime and Punishment", 1866, "fiction");
		Movie m1 = new Movie("Pixar", "Toy Story", 1995, "cartoon");
		Movie m2 = new Movie("Michael Crichton", "Jurrassic Park", 1993, "Science Fiction");
		
		
		
        Predicate<Media> olderThan = b -> (b.getYearPublished()<b1.getYearPublished());
        
        System.out.println(olderThan.test(b2));
        
        
    }
}
