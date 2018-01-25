package com.revature.homework1;
/*
 * Q11. Write a program that would access two float-variables 
 * from a class that exists in another package. Note, you will 
 * need to create two packages to demonstrate the solution.
 * */
import static homework1a.Question11.*;
public class Question11 {
	public static void main(String[] args){
		
	System.out.println(homework1a.Question11.a);
	System.out.println(homework1a.Question11.b);
	}
}
