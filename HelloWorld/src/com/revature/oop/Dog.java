// Created on 1/23/2018

package com.revature.oop;

public class Dog extends Animal {

	public static String latinName = "canus lupus familiaris";
	
	private String name;
	
	public void wagTail() {
		System.out.println("tail is wagging");
	}
	
	@Override
	public void makeNoise() {
		System.out.println("woof woof");
	}
	
	
}
