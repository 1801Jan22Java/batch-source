package com.revature.abstraction;

public abstract class Rectangle implements Shape {

	private Double length;
	
	private Double width;

	@Override
	public Double calculateArea() {
		
		return length * width;
	}

	public Rectangle(Double length, Double width) {
		super();
		this.length = length;
		this.width = width;
	}

	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public Double calculatePerimeter() {
		return length + length + width + width;
	}
	
	
	
}
