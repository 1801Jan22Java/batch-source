package com.revature.abstraction;

public class Circle implements Shape{
	public Circle(Double radius) {
		super();
		this.radius = radius;
	}

	private Double radius;

	@Override
	public Double calculateArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	@Override
	public Double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
}
