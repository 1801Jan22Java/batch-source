package com.revature.homework1;
//James Whitten

import java.io.*;

public class Question20 {

	//Our main
	public static void main(String[] args) {
	
		String filename = "src/data.txt";
		//Getting the entire file into a string
		String ourString = readFile(filename);
		//Formatting the file string
		String finalString = formatString(ourString);
		//Our formatted String
		System.out.println(finalString);
	
	}
	
	//Method for reading the file and extracted the text to a String
	public static String readFile(String filename)
	{
		try {
			//Setup Filereader
			FileReader fileReader = new FileReader(filename);
			//Setup BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String nextLine =  bufferedReader.readLine();
			//Our accumulating String
			String totalString = "";
			
			
			//If null we have no more text so we skip looking for more text
			if (nextLine != null)
			{
				//Adding text until we have all our text
				while (nextLine != null)
				{
					totalString = totalString +  ":" + nextLine;
					nextLine = bufferedReader.readLine();			
				}
			}
		

			//Close our reader
			bufferedReader.close();
			
			return totalString;
			
		//For catching any problems
		}catch(FileNotFoundException e)
		{
			System.out.println("File was not found!");
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//If it fails we must return something
		return "";
	}
	
	//Takes our unformatted file String and then formats it into the desired format
	public static String formatString(String ourString)
	{
		String[] splitString = ourString.split(":");
		String formattedString = "";
		
		//Breaks up the formatting into a block of 4 to follow the formatting template
		for (int i = 0; i < splitString.length/4; i++)
		{
			String tempString = "";
			//Sets of 4 are used to follow the format
			for (int j = 0; j < 4; j++)
			{
				if (j==0)
				{
					//Line 1 first half
					tempString = "\n" + "Name: " + splitString[(i*4)+j +1];
				}
				else if (j==1)
				{
					//Line 1 second half
					tempString = tempString + " " + splitString[(i*4)+j+1];
				}
				else if (j==2)
				{
					//Line 2
					tempString = tempString + "\n" + "Age: " + splitString[(i*4)+j+1] + " years";
				}					
				else if (j==3)
				{
					//Line 3
					tempString = tempString + "\n" + "State: " + splitString[(i*4)+j+1] + " State";
				}
			}
			//Aggregating each formatting section String to our final String
			formattedString = formattedString + tempString;
		}
		
		return formattedString;
	}
	
}
