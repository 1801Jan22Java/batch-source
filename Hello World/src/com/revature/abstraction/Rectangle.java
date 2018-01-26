package com.revature.abstraction;

public abstract class Rectangle implements Shape{
	
	private Double length;
	private Double width;
	
	@Override
	public Double calculateArea() {
		return length * width;
	}
	
	@Override
	public Double calculatePerimeter() {
		return (length * 2) + (width * 2);
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
	
}
