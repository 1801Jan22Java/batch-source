package com.revature.abstraction;

public  class Circle implements Shape {

	private Double radius;
	
	public Circle() {
		super();
	}

	public Circle(Double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public Double calculateArea() {
		return Math.PI*radius*radius;
	}
	
	@Override
	public Double calculatePerimeter() {
		return Math.PI*2*radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
}
