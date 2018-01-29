package com.revature.homework1;
/*
 *  Create a notepad file called Data.txt and enter the following:
 *  Mickey:Mouse:35:Arizona
 *  Hulk:Hogan:50:Virginia
 *  Roger:Rabbit:22:California
 *  Wonder:Woman:18:Montana
 *  Write a program that would read from the file and print it out to the screen in the following format:
 *  Name: Mickey Mouse
 *  Age: 35 years
 *  State: Arizona State
 */

import java.io.*;

public class Question20 
{
	public static void main(String args[])
	{
		File file = new File("C://Users/panda/Documents/GitRepos/1801-jan22-java/batch-source/Assignments/src/com/revature/homework1/Question20.txt");

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String next;
			String word = br.readLine();
			while(word != null)
			{
				//Given that I know the format of the input file,
				//I can format the out put based on the : that seperates the words
				//Since I know how many words are required in the file per line, 
				//I can use the resulting String array in a pretty straight forward output 
				String[] eachWord = word.split(":");
				System.out.println("Name: "+eachWord[0]+" "+eachWord[1]);
				System.out.println("Age: "+eachWord[2]);
				System.out.println("State: "+eachWord[3]);
				word = br.readLine();
			}
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}
