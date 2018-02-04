package question11package2;

// Q11. Write a program that would access two float-variables from a class that exists in another
// package. Note, you will need to create two packages to demonstrate the solution.
public class Question11 {

	// data fields
	private float float1 = 10.0f;
	private float float2 = 15.4f;
	
	// no-arg constructor
	public Question11() {
		super();
	}
	
	// overloaded constructor
	public Question11(float float1, float float2) {
		super();
		this.float1 = float1;
		this.float2 = float2;
	}

	// getter/setter methods
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
