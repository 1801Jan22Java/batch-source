package com.revature.abstraction;

public class Rectangle {

	public Rectangle() {
		
	}
	
	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}
	protected double height;
	protected double width;
	
	public double calculateArea(double height, double width) {
		return height*width;
	}
}
