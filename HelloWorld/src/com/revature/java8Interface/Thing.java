package com.revature.java8Interface;

public interface Thing {
	default void method() {
		System.out.println("I cant be final");
	}
}
