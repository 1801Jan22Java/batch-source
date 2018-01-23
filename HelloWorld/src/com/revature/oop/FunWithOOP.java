package com.revature.oop;

public class FunWithOOP {
	
	public static void main(String[] args) {
		
		//create new Animal
		
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		//polymorphic instance method toString
		
		Object fluffy2 = new Animal();//implicit upcasting
		//In order to access the Animal methods, we need to cast
		//no implicit downcasting
		((Animal)fluffy2).setName("fluffy2");
		//but when we call fluffy.toString, we get tthe Animal version.
		System.out.println(fluffy2.toString());
		
		//at compile time the declared type is checked
		//casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		//((Animal)fluffy3).setName("fluffy3");
		//This will be a class cast exception.
		//at runtime the actual type is checked
		
		Cat c1 = new Cat("Paul", 8);
		Cat c2 = new Cat("Peter", 7);
		Dog d1 = new Dog();
		
		/*
		 * Arrays:
		 * Elements must be of the same type, length must be specified
		 * length is immutable (continuous block of memory is allocated)
		 * java.util.Arrays (note the s) for useful methods
		 * all elements are set to default value for that data type
		 */
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		for (int idx = 0; idx< animalArray.length; idx++) {
			animalArray[idx].makeNoise();
		}
		
		//best practices: refer to static members via class
		System.out.println(Cat.catLatinName);
		
		Dog d2 = new Dog();
		
		//This will change the static field for all instances of dog
		d2.dogLatinName = "doggus doggus";
		
		System.out.println(d1.dogLatinName);
		System.out.println(d2.dogLatinName);
		
	}
	
}
