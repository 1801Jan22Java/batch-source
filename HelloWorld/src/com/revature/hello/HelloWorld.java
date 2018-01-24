package com.revature.hello;
/*
 * package - a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang 
 */

import com.revature.oop.*;
import static com.revature.oop.Cat.*;

public class HelloWorld {
	/*
	 *  >> Naming conventions
	 *  classes and objects : pascal casing, FirstSecondThird
	 *  methods and variables : camel casing, firstSecondThird
	 *  package names : all lowercas, separated by periods, e.g. com.revature.[other stuff]
	 *  constants : FIRST_SECOND_THIRD
	 */
	
	/*
	 *  >> main method
	 *  JVM looks for a method with this signature as an entrance point to the program
	 */
	
	public static void main(String[] args) {
		// static : don't need an instance of HellowWorld to execute the method
		// void : return type, doesn't return anything
		// String[] args : array of string parameter to pass to main()
		
		// sysout+ctrl+space
		System.out.println("Hello World!");
		
		// STS (+eclipse) does incremental compiling 
		// every time a file is saved, it and any of its dependencies are compiled
		// compiling : converting .java source files into .class bytecode for execution by the JVM
		
		
		
		// access things from our OOP package
		// could use our fully qualified classname 
		com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");	// very annoying..
		
		// or use an import
		Dog d = new Dog();
		
		
		// using a static import
		System.out.println(catinName);		// without import static com.revature.oop.Cat.* , it shouls say 'Cat.catinName')
	}
}
