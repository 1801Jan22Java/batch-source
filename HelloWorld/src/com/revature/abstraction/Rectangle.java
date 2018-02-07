package com.revature.abstraction;

public abstract class Rectangle implements Shape{
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rectangle(Double length, Double width) {
		super();
		this.length = length;
		this.width = width;
	}
	private Double length;
	private Double width;
	
	@Override
	public Double calculateArea() {
		return width*length;
	}
	@Override
	public Double calculatePerimeter() {
		return 2*(width+length);
	}
	
	

}
