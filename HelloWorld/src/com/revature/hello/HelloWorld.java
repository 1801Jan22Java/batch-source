package com.revature.hello;
/*
 * package - a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 */

public class HelloWorld {
	
	/*
	 * Naming conventions:
	 * Classes and Projects are PascalCased
	 * Methods and Properties are camelCased
	 * Package names are all lowercase, separated by periods (com.revature.[stuffs])
	 * 	Each period separated word corresponds to the level in the structure
	 * Constants are ALL_CAPS_WITH_UNDERSCORES
	 */
	
	/*
	 * main method
	 * JVM looks for  a method with this signature for an entry point
	 */
	
	public static void main(String [] args) {
		// static: won't need instance of HelloWorld to execute this method
		System.out.println("Hello World");
	}
	
}
