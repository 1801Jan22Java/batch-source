package com.revature.hello;
/*package - namespace that organizes a set of related classes and interfaces
* corresponds to a folder structure
* base package for /Java is java.lang
*/
import com.revature.oop.*;
//Static imports only the members of a certain class
import static com.revature.oop.Cat.*;
public class HelloWorld
{
	/*
	 * Naming Converntion
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: lowercase, seperated be periods, ie com.revature.otherstuff
	 * consants: Capitol letters seperated by _, ie FIRST_SECOND_THIRD, also used for variables that are static
	 * and final
	 */
	public static void main(String args[])
	{
		/*
		 * Point of entry for our program
		 * JVM looks for a method with this signature as an entry point to the program
		 */
		//static: you don't need an instance of this type to execute the method
		//void: returns nothing
		//String args[]: allows you to pass an array of strings as parameters
		
		//Prints to the console
		System.out.println("Hello World!");
		
		//STS(eclipse) does incremental compiling
		//every time a file is saved, it and all dependencies are compile
		//compiling from .java(java) into .class(bytecode)
		
		//access things from our OOP package
		//could use our fully qualified classname
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		//OR!!! you coud just import the package
		Animal b = new Animal("Ted");
		//Using our static import...
		System.out.println(catinName);
	}
}
