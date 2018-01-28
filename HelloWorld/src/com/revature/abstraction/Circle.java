package com.revature.abstraction;

public abstract class Circle implements Shape{

	private Double radius;

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	@Override
	public Double calculateArea() {
		// TODO Auto-generated method stub
		return Math.PI*radius*radius;
	}

	@Override
	public Double calculatePerimeter() {
		// TODO Auto-generated method stub
		return Math.PI*2*radius;
	}
	
	
}
