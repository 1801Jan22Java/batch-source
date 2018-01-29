package com.revature.abstraction;

public class Circle implements Shape
{
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Double radius;

	@Override
	public Double calculateArea() 
	{
		return Math.PI*radius*radius;
	}

	@Override
	public Double calculatePerimeter() 
	{
		return Math.PI*2*radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	
}
