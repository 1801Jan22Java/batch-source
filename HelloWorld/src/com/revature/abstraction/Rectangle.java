package com.revature.abstraction;

public abstract class Rectangle implements Shape{
	
	private double length, width;
	
	public double calculateArea()
	{
		return length*width;
		
	}
	
	public double calculatePerimeter()
	{
		return 2*length+2*width;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}
	

}
