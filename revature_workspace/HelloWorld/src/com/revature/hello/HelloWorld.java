package com.revature.hello;
/*
 * Packages are essentially folders or namespaces
 * that organize a set of related classes and 
 * interfaces.
 * Corresponds to a folder structure.
 * Base package for Java is java.lang
 * */

import com.revature.oop.*;

//Need to specify class - not just package for static imports
import static com.revature.oop.Cate.*;

public class HelloWorld {
	
	/*
	 * Naming conventions:
	 *  Classes and projects
	 *  Classes should be named thusly:
	 *  Pascal case: FirstSecondThird
	 *  Methods and variables: 
	 *  Camel case: firstSecondThird.
	 *  Package names: lowercase, separated by periods
	 *  e.g. com.revature.otherstuff
	 *  
	 *  Constants: All caps and underscores.
	 *   Ex. FIRST_SECOND_THIRD
	 * */

	/*
	 * JVM looks for method with this signature 
	 * as the entrance point of the program
	 * */
	public static void main(String [] args)
	{
		//static method - we don't need an instance of HelloWorld to execute.
		// void - no return value
		// String[] args: Can pass in array of strings as arguments
		
		System.out.println("Zdravstvuite mir!");
		
		//STS (and, under the hood, Eclipse) 
		//does incremental compiling
		//Every time a file is saved, it and any dependencies are 
		// compiled - source files will have .java converted into .class
		// byte code for execution
		
		//Access things from OOP package.
		// Could use fully qualified classname
		com.revature.oop.Animal a = new com.revature.oop.Animal("Kirk");
		//or use import
		Doge d= new Doge();
		
		//using static import
		System.out.println(Cate.catLatinName);
		
	}
}
