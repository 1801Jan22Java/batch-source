package com.revature.oop;

public class FunWithOop {
	
	public static void main (String[] args) {
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		//polymorphic instance method: toString
		Object fluffy2 = new Animal(); //implicit upcasting 
		//fluffy2.setName("fluffy2"); wont work
		
		((Animal)fluffy2).setName("fluffy2");
		// in order to access the Animal methods, we need to cast
		// have no implicit downcasting, when we call fluffy2.toString(),
		// we get the animal version. 
		
		//System.out.println(fluffy2.toString());
		
		// at compile time, the declared type is checked
		// casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		//((Animal)fluffy3).setName("fluffy3");
		// throws class cast exception!
		// actual type is checked at runtime
		
		Cat c1 = new Cat(8, "Paul");
		Cat c2 = new Cat(7, "Peter");
		Dog d1 = new Dog();
		
		/*
		 * Arrays: 
		 * Elements must be of the same type, length must be specified
		 * length of array is immutable 
		 * java.util.Arrays for useful methods
		 * all set to default value for that datatype
		 */
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		for(int i = 0; i < animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		System.out.println(Cat.catinName);
		// best practices - refer to static members by class
		
		Dog d2 = new Dog();
		
		// this will change the static field for ALL instances of dog
		d2.LatinName = "doggus doggus";
		
		System.out.println(d1.LatinName);
		System.out.println(d2.LatinName);
		
	}
		
}

