package com.revature.abstraction;

public class Circle implements Shape{
	
	public Circle(Double radius) {
		super();
		this.radius = radius;
	}

	private Double radius;

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	@Override
	public Double calculateArea() {
		return Math.PI*radius*radius;
	}

	@Override
	public Double calculatePerimeter() {
		return Math.PI*radius*2;
	}
	
}
