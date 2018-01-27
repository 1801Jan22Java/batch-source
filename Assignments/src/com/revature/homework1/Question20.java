package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Create a notepad file called Data.txt and enter the following:

Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State

 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Question20 {

	public static void main(String[] args) {
		// delare variables
		String[] person;
		String age;
		String state;
		// to store people from file read
		ArrayList<String> people = new ArrayList<>();
		StringBuilder name = new StringBuilder("");
		
		// read from a file
		File ingest = new File("src/Data.txt"); 
		
		try {
			Scanner input = new Scanner(ingest);
			// store reads in an ArrayList
			while(input.hasNextLine()) {
				people.add(input.nextLine());
			}
			input.close();
		// in case file doesn't exist
		} catch (FileNotFoundException e) {
			System.out.println("I can't find this file.");
			e.printStackTrace();
		}
		// embedded code because for retrieving a person
		person = people.get(0).split("[:]"); 
		
		// display, parse the information from retrieved person
		for(int i = 0; i < person.length; i++) {
			if(i == 0) {
				name.append(" " + person[i]);
			} 
			else if(i == 1) {
				name.append(" " + person[i]);
				System.out.println("Name:" + name);
			}
			else if (i == 2) {
				age = person[i];
				System.out.println("Age: " + age + " years");
			} 
			else {
				state = person[i];
				System.out.println("State: " + state + " State");
			}
				
		} // end for
		
	} // end main()

} // end class
