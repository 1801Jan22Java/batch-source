package com.revature.oop;

public class FunWithOop {
	
	public static void main(String[] args) {
		//create new animal
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		//polymorphic instance method: toString
		Object fluffy2 = new Animal();
		((Animal) fluffy2).setName("fluffy2");
		System.out.println(fluffy2.toString());
		//in order to access the Animal methods, we need to cast
		//no implicit downcasting
		
		//at compile time, the declared type is checked
		//casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		//((Animal) fluffy3).setName("fluffy3");
		//this throws a ClassCastException
		
		Cat c1 = new Cat(8, "Paul");
		Dog d1 = new Dog();
		Cat c2 = new Cat(7, "Peter");
		
		/*
		 * Arrays:
		 * Elements must be of the same type, length must be specified
		 * length is immutable (contiguous block of memory is allocated)
		 * java.util..Arrays (note the "s") for useful methods
		 * all elements are set to default value for that data type (usually NULL)
		 */
		
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		for (int i=0; i<animalArray.length; i++) {
			animalArray[i].makenoise();
		}
		
		//best practices refer to static members via the class
		System.out.println(Cat.catinName);
		
		Dog d2 = new Dog();
		
		//this will change the static field for ALL INSTANCE OF DOG
		d2.latinName = "doggus doggus";
		
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
		
	}
	
}
