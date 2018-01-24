package com.revature.OtherPackage;
//This class is for Question11.java to access
public class ClassInAnotherPackage {
	private float float1;
	private float float2;
	
	public static final float STATIC_FLOAT  = 9540.230f;
	
	public ClassInAnotherPackage() {
		super();
		
	}
	public ClassInAnotherPackage(float float1, float float2) {
		super();
		this.float1 = float1;
		this.float2 = float2;
	}
	public float getFloat1() {
		return float1;
	}
	public void setFloat1(float float1) {
		this.float1 = float1;
	}
	public float getFloat2() {
		return float2;
	}
	public void setFloat2(float float2) {
		this.float2 = float2;
	}
	
}
