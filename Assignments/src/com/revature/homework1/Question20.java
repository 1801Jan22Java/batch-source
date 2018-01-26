package com.revature.homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Homework 1. Question 20. File play.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question20 {
	
	/**
	 * Converts given lines to new format and prints them to console.
	 * Lines should contain exactly 3 colons separated by letters or numbers. 
	 * If not, the line is not printed.
	 * 
	 * @param data The list of lines to be formatted
	 * @throws IllegalArgumentException if data or any string inside data is null
	 * @return No return value
	 */
	private static void formatPrint(List<String> data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		
		for (String s : data) {
			// Skip if number of colons not exactly 3
			if (countColons(s) != 3) {
				continue;
			}
			
			String[] members = s.split(":");
			
			// Skip if exactly 4 strings are not generated
			// Further, skip if any string is whitespace
			// Do not need to check for last element since
			// it would not be included by the split method
			if (members.length != 4
					|| members[0].trim().length() == 0
					|| members[1].trim().length() == 0
					|| members[2].trim().length() == 0) {
				continue;
			}
			
			System.out.println("Name: " + members[0] + " " + members[1]);
			System.out.println("Age: " + members[2] + " years");
			System.out.println("State: " + members[3] + " State");
			System.out.println();
		}
	}
	
	/**
	 * Counts number of colons in given string
	 * 
	 * @param s String whose colons to count
	 * @throws IllegalArgumentException if s is null
	 * @return Number of ':' characters in s
	 */
	private static int countColons(String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			// Increment counter if comma found
			if (s.charAt(i) == ':') {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		// This should work on eclipse. Might not work in a command line.
		File file = new File("src/com/revature/homework1/Data.txt");
		
		try {
			Scanner sc = new Scanner(file);
			// List to contain lines of text
			List<String> data = new ArrayList<String>();
			
			// Fill list with individual lines
			while (sc.hasNextLine()) {
				data.add(sc.nextLine());
			}
			
			formatPrint(data);
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error. File not found!");
		}
		
	}

}
