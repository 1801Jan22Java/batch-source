package com.revature.abstraction;

public class Circle implements Shape
{
	private Double radius;

	public Circle()
	{
		
	}
	
	public Circle(Double radius) {
		super();
		this.radius = radius;
	}
	
	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double calculateArea()
	{
		return Math.PI*radius*radius;
	}
	
	public Double calculatePerimeter()
	{
		return 2*Math.PI*radius;
	}
}
