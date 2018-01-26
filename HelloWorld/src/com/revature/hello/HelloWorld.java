package com.revature.hello;
/*
 * a package is a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for java is java.lang
 */
import com.revature.oop.*;
import static com.revature.oop.Cat.*;

public class HelloWorld {
	/*
	 * Naming conventions
	 * classes and project: pascal casing
	 * variables and methods: camel casing
	 * package names: lower case, separated by periods, 
	 * constants: all caps 
	 * 
	 * 
	 */

	/*
	 * main method 
	 * JVM looks for a method with this signature as an entrance point to program
	 * 
	 */
	public static void main(String[] args) 
	{
		//static: doesn't need an instance of HelloWorld to execute the method 
		//void: return type
		//String[] args: array of string parameter to pass to main
		
		System.out.println("Hello World");
		//STS does incremental compiling 
		//every time a file is saved, it and any of its dependencies are compiled
		//compiling convertiong .java source files into .class bytecode
		
		//access things from our OOP package 
		com.revature.oop.Animal a = new com.revature.oop.Animal();
	}
}
