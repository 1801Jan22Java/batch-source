package com.revature.homework1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Question14 
{
	public static void switchExample()
	{
		String java = "java";
		switch(java)
		{
		case "paul": 
			System.out.println(Math.sqrt(8));
			break;
		case "java": 
			LocalDate date = LocalDate.now();
			System.out.println(date.toString());
			break;
		case "john": 
			System.out.println("I am learning Core Java".split(" "));
			break;
			default: 
				System.out.println("Hello World!");
				break;
		}

	}
}
