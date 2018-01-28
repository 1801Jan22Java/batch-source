package com.revature.abstraction;

public abstract class Rectangle implements Shape {

	private Double length;
	private Double width;
	
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rectangle(Double length, Double width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return length*width;
	}
	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2*length + 2*width;
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
