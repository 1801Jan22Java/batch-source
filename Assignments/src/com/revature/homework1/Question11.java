package com.revature.homework1;

// import com.revature.homework1Q11.Silly;

/**
 * Homework 1. Question 11. Package travelling.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question11 {

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		// Better to import at the top as shown on line 3 
		// to avoid writing the entire qualified name
		com.revature.homework1Q11.Silly s = new com.revature.homework1Q11.Silly();
		
		// Accessing the floats
		s.first = 3.5f;
		s.second = 4.33f;
		
		System.out.println(s.first + " plus " + s.second + " is " + (s.first + s.second));
		
	}

}
