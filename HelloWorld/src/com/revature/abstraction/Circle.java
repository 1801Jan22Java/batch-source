package com.revature.abstraction;

public  class Circle implements Shape{
	
	private Double radius;

	@Override
	public Double calculateArea() {
		
		return Math.PI*radius*radius;
	}

	@Override
	public Double calculatePerimeter() {
		return 2*Math.PI*radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

}
