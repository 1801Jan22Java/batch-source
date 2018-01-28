// Date: 1/22/2018
// Imports on 1/23/2018

package com.revature.hello;
/*
 * package - a namespace that organizes a set of related classes and interfaces
 * - corresponds to a folder structure
 * - base package for Java is java.lang
 */

import com.revature.oop.*;
import static com.revature.oop.Cat.*;	// have to import static members of a class, not a package

public class HelloWorld {

	/*
	 * Naming Conventions:
	 * - Classes and Projects: Pascal Casing, FirstSecondThird
	 * - Methods and Variables: Camel Casing, firstSecondThird
	 * - Packages: lowercase, separated by periods, e.g. com.revature[other stuff]
	 * - Constants: FIRST_SECOND_THIRD
	 */
	
	/*
	 * Main Method:
	 * - JVM looks for a method with this signature as an entrance point to the program 
	 * (a little different for web applications) 
	 */
	public static void main(String[] args) {
		// static: do not need an instance of HelloWorld to execute the method
		// void: return type, does not return anything
		// String[] args: array of string parameter to pass to main(),
		// this is useful for running from command line
		
		// sysout+ctrl+space
		System.out.println("Hello World!");
		
		// STS (and, under the hood, Eclipse) does incremental compiling
		// every time a file is saved, it and any of its dependencies are compiled
		// Compiling: converting .java source files into .class (bytecode, to be executed by JVM) 
	
	
		// Date: 1/23/2018
		// Access things from our OOP package
		// Could use our fully qualified class name
		com.revature.oop.Animal animal = new com.revature.oop.Animal("Fred");
		
		// Or use an import
		Dog dog = new Dog();
		
		// Using static import
		System.out.println(Cat.catinName);
		
	}
}
