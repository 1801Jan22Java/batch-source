package com.revature.homework1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Create a notepad file called Data.txt and enter the following:
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
Write a program that would read from the file and print it out to the screen in the following
format:
Name: Mickey Mouse
Age: 35 years
State: Arizona State
 */
public class Question20 {

	private String[] names;
	private Integer[] ages;
	private String[] states;
	private String line;
	private String[] people;

	public void doThing() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
		try {
			line = reader.readLine();
			people = line.split(":");
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
