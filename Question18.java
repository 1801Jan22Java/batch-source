package com.revature.homework1;

abstract class AbstractClass{
	public abstract boolean checkUpperCase(String target);
	
	public abstract String makeUpperCase(String target);
	
	public abstract void convertString(String target);
}

class ConcreteClass extends AbstractClass{
	
	public boolean checkUpperCase(String target) {
		String test = target.toLowerCase();
		return (target != test);
	}
	
	public String makeUpperCase(String target) {
	    return target.toUpperCase();
	}
	
	public void convertString(String target) {
		System.out.println(Integer.parseInt(target) + 10);
	}
}

class Question18{
	public static void main(String[] args) {
		ConcreteClass obj = new ConcreteClass();
	    System.out.println(obj.checkUpperCase("false"));
	    System.out.println(obj.checkUpperCase("True"));
	    System.out.println(obj.makeUpperCase("MiXeD"));
	    obj.convertString("123");
	}
	

}