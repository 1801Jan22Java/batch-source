package com.revature.homework1Resource;

public class Question11Resource {

	
	// normally field in other packages are hidden for security using private
	private float no1 = 3.14F;		
	private float no2 = 4.33F;
	
	public Question11Resource() {
		super();
	}
	
	public Question11Resource(float no1, float no2) {
		super();
		this.no1 = no1;
		this.no2 = no2;
	}

	// to access the private values here, use get/set
	public float getNo1() {			
		return no1;
	}
	public void setNo1(float no1) {
		this.no1 = no1;
	}
	public float getNo2() {
		return no2;
	}
	public void setNo2(float no2) {
		this.no2 = no2;
	}

	@Override
	public String toString() {
		return "Question11Resource [no1=" + no1 + ", no2=" + no2 + "]";
	}
	
}
