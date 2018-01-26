package com.revature.abstraction;

public abstract class Circle implements Shape{
	
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	private double radius;

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double calculateArea()
	{
		return Math.PI*radius*radius;
	}
	
	public double calculatePerimeter()
	{
		return Math.PI*2*radius;
	}

}
