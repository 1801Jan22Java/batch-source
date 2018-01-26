package com.revature.abstraction;

<<<<<<< HEAD
public  class Circle implements Shape{
	
=======
public class Circle implements Shape {
	
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circle(Double radius) {
		super();
		this.radius = radius;
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	private Double radius;

	@Override
	public Double calculateArea() {
<<<<<<< HEAD
		
=======
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		return Math.PI*radius*radius;
	}

	@Override
	public Double calculatePerimeter() {
<<<<<<< HEAD
		return 2*Math.PI*radius;
=======
		return Math.PI*2*radius;
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

}
