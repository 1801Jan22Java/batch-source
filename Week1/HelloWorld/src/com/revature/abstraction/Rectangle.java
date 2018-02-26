package com.revature.abstraction;

public abstract class Rectangle implements Shape
{
	private Double length;
	private Double width;
	
	Rectangle()
	{
		
	}
	
	public Rectangle(Double length, Double width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double calculateArea()
	{
		return length*width;
	}
	
	public Double calculatePerimeter()
	{
		return 2*(length+width);
	}
}
