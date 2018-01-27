package com.revature.homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Author: Calvin Milliron
 * Assignment: Create a notepad file called Data.txt and enter the following:
 *
 *		Mickey:Mouse:35:Arizona
 *		Hulk:Hogan:50:Virginia
 *		Roger:Rabbit:22:California
 *		Wonder:Woman:18:Montana
 * 
 *		Write a program that would read from the file and print it out to the screen in the following format:
 * 
 *		Name: Mickey Mouse
 *		Age: 35 years
 *		State: Arizona State
 * Status: Done
 */
public class Question20 {

	public static void main(String[] args) {
		// Access file from com.revature.homework1 working directory
		File file = new File("src\\com\\revature\\homework1\\Data.txt");
		try {
			Scanner input = new Scanner(file);
			// Read in each line from file as string
			while(input.hasNextLine()) {
				String temp = input.nextLine();
				// Break up sections of each line separated by a colon
				String[] array = temp.split(":");
				// The first and second sections are first and last name
				System.out.println("Name: " + array[0] + " " + array[1]);
				// The third section is the age
				System.out.println("Age: " + array[2] + " years");
				// The fourth section is the state
				System.out.println("State: " + array[3] + " State");
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("Sorry, that file was not found.");
		}
	}

}
