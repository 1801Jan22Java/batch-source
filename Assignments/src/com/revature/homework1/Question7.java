package com.revature.homework1;

/*
 * Sort two employees based on their name, department, and age using the Comparator
interface.
 */
public class Question7 implements Comparable<Question7>{

	private String name;
	private String dept;
	private int age;
	
	public Question7() {
		name = "";
		dept = "";
		age = 0;
	}
	
	public Question7(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}


	@Override
	public int compareTo(Question7 e) {
		if(this.name.compareTo(e.getName()) == 0) {
			if(this.dept.compareTo(e.getDept()) == 0) {
				if(this.age == e.getAge())
					return 0;
				else
					return (this.dept.compareTo(e.getDept()));
			}
			else
				return this.name.compareTo(e.getName());
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}
	

	
}


