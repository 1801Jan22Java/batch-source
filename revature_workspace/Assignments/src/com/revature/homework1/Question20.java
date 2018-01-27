package com.revature.homework1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

// Creating a Person class to hold values
class Person 
{
String firstName;
String lastName;
int age;
String state;

//Person constructor
Person(String fName,String lName,int age, String state){
	firstName=fName;
	lastName=lName;
	this.age=age;
	this.state=state;
}
// For the purposes of this class / the homework, getters and setters seem unnecessary

//Person toString. 
	public String toString()
	{
		String personStr= "Name: "+firstName + " "+lastName + "\nAge: " + this.age + " years"+ "\nState: " + this.state + " State";
		return personStr; 
	}
	


}
public class Question20 {

public static void displayData(ArrayList<String[]> personList)
{
	for(String[]str : personList)
	{
		//System.out.println(str[1]);
		Person p =new Person(str[0],str[1],Integer.parseInt(str[2]),str[3]);
		System.out.println(p.toString());
	}
	
}
public static ArrayList<String[]> intakeData(File file){
	FileReader fr;
	BufferedReader textReader;// = new BufferedReader(fr);
	ArrayList<String[]> personList=  new ArrayList<String[]>();
	try{
		
		fr = new FileReader("Data.txt");
		textReader = new BufferedReader(fr);
	int numLine=0;
	String newLine =textReader.readLine();

	personList.add(newLine.split(":"));
	while(newLine!=null)
	{
		//personList.add(newLine);
		String [] features = newLine.split(":");
		personList.add(features);
		newLine=textReader.readLine();	
		//System.out.println(newLine);	
		//numLine++;//DEBUGGING
		
	}
	//System.out.println(numLine);//DEBUGGING
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
	
	return personList;
	}
}
