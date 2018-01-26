package com.revature.homework1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.util.stream.Stream;

public class Question20 {
/*
 * Gin/Q20. Create a notepad file called Data.txt and enter the following:

	Mickey:Mouse:35:Arizona
	Hulk:Hogan:50:Virginia
	Roger:Rabbit:22:California
	Wonder:Woman:18:Montana
	 
	Write a program that would read from the file and print it out to the screen in the following format:
	 
	Name: Mickey Mouse
	Age: 35 years
	State: Arizona State

 */
	public static void main(String[] args) {
		
		String thisLine = null;
		URL url = Question20.class.getResource("Data.txt");
		 
		try {
			FileReader fr = new FileReader(url.getPath());
			BufferedReader br = new BufferedReader(fr);
			while((thisLine = br.readLine()) != null) {
				String[] profiles = thisLine.split(":");
				System.out.println("Name: "+ profiles[0] + " " + profiles[1] + "\nAge: "+ profiles[2] + " years \nState: " + profiles[3] + " State");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
