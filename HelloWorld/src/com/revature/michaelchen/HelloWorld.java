package com.revature.michaelchen;

/* 
 * package is a namespace that organizes a set of related classes and interfaces
 * base package for Java is java.lang
 */

import com.revature.oop.*;

import static com.revature.oop.Cat.*;

public class HelloWorld {
	
	/* 
	 * Naming conventions:
	 * classes and projects: pascal casing e.g. FirstSecondThird
	 * methods and variables: camel casing e.g. firstSecondThird
	 * package names: all lower-case, separated by periods e.g. com.revature.whatevertheheckyouwant
	 * constants: all upper-case e.g. FIRST_SECOND_THIRD
	 */
	
	/*
	 * main method
	 * JVM looks for a method with this signature as an entrance point to the program
	 */
	
	public static void main (String[] args) {
		// static: don't need an instance of HelloWorld to execute the method
		// void: return type, doesn't return anything
		// String[] args: array of string parameter to pass to main()
		
		// sysout+ctrl+space
		System.out.println("Hello World!");
		
		// STS (and Eclipse) does incremental compiling every time a file is saved, it and any
		// of its dependencies are compiled
		
		// compiling: converting .java source files into .class bytecode for execution by the JVM
		
		//access things from out OOP package
		// could use fully qualified classname
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		
		// or can import the package and make it less wordy
		Dog d = new Dog();
		
	}
	
}
