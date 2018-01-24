package com.revature.abstraction;

public abstract class Rectangle implements Shape {

	private Double length;
	private Double width;
	
	public Rectangle(Double length, Double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public Double calculateArea() {
		return length*width;
	}
	
	@Override
	public Double calculatePerimeter() {
		return 2*(length+width);
	}
}
