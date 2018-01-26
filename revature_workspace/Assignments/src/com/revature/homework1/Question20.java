package com.revature.homework1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * 
 * 
Q20. Create a notepad file called Data.txt and enter the following:

Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State

 * */
public class Question20 {
	public static void main(String [] args){
	
	File file;
	FileReader fr;
	BufferedReader textReader;// = new BufferedReader(fr);
	try{
		file = new File("Data.txt");
		fr = new FileReader("Data.txt");
		textReader = new BufferedReader(fr);
	int numLine=0;
	while(textReader.readLine()!=null)
	{
		System.out.println(textReader.readLine());
		numLine++;
	
	}
	System.out.println(numLine);
	textReader.close();
	fr.close();
	
	}
	catch(FileNotFoundException fnfe)
	{
		fnfe.printStackTrace();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	
	
	}
}
