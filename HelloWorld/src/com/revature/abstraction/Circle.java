package com.revature.abstraction;

public class Circle implements Shape {

	private Double radius;		// Of the double wrapper class type

	public Circle(Double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI*radius*radius;
	}

	@Override
	public double calculatePerimeter() {
		return Math.PI * 2 * radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	
}
