package com.revature.hello;
/*
 * package - a namespace taht organizes a set of related classes and interfaces 
 * corresponds to a folder structure
 * base package for java is java.lang
 */
public class HelloWorld {
	
	/*
	 * Naming conventions:
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods
	 * constants: all caps, underscores between multiple words, FIRST_SECOND_THIRD
	 */
	
	/*
	 * main method
	 * JVM looks for a method with this signature as an entrance point to the program
	 */
	public static void main(String[] args) {
		//static: don't need an instance of HelloWorld to execute the method
		//void: returns nothing
		//String[] args: array of sting parameters passed to main
		
		//sysout+ctrl+space
		System.out.println("Hello World!");
		
		//STS (and eclipse) does incremental compiling
		//every time a file is saved, it and any of it's dependencies are compiled
		//compiling: converting .java source files into .class bytecode for execution by the JVM
	}
}
