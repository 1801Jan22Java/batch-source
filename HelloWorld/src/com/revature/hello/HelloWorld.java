package com.revature.hello;

// package is a namespace that organizes files
// corresponds to folder structure 
// base package for java is java.lang

public class HelloWorld {
	/*
	 *  Naming conventions 
	 *  classes and project: pascal casing, FirstSecondThird
	 *  methods and variables: camel casing, firstSecondThird
	 *  package names : lowercase, separated by periods. eg com.revature.w/e
	 *  constants: All_CAPS
	 */
	
	/*
	 * main method is where the program will begin
	 * JVM looks for a method with this signature as an entrance point 
	 * to the program
	 */
	public static void main(String [] args) {
		// static methods dont need an instance to executing anything
		System.out.print("Hello World");
		// sysout+ctl+space
		// interpreter and compiler java byte code machiene coder output
		// every time a file is saved it and any of its dependancies are compiled
		// compiling converts java syntax into byte code .java converted to .class
		
	}

}
