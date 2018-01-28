package com.revature.homework1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

	private ArrayList<String> names;
	private ArrayList<String> ages;
	private ArrayList<String> states;
	private String line;
	private String[] people;

	public void doThing() throws FileNotFoundException {
		File file = new File("src\\com\\revature\\homework1\\Data.txt");
		names = new ArrayList<String>();
		ages = new ArrayList<String>();
		states = new ArrayList<String>();
		FileReader fReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fReader);
		try {
			line = reader.readLine();
			while (line != null) {
				people = line.split(":");
				people[0].concat(" ");
				names.add(people[0].concat(people[1]));
				ages.add(people[2]);
				states.add(people[3]);
				line = reader.readLine();
			}
			reader.close();
			System.out.println("Reached end of file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println("Name : " + names.get(i));
			System.out.println("Age: " + ages.get(i) + " years");
			System.out.println("State: " + states.get(i));
			
		}
		
	}

}
