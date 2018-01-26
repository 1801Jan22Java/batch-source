package com.revature.oop;

public class FunWithOop {

	public static void main(String[] args) {
		
		Animal fluffy  = new Animal();
		System.out.println(fluffy.toString());
		
		//polymorphic instance method: toString
		Object fluffy2 =  new Animal();		//implicit upcasting
		((Animal)fluffy2).setName("fluffy2");
		//in order to access the Animal methods, we need to cast
		//no implicit downcasting
		// when we call fluffy2.toString, we get the Animal version
		System.out.println(fluffy2.toString());
		
		//at compile time the declared type is checked
		//casts can work at compile time up or down the inheritance tree
		Object fluffy3 = new Object();
		//((Animal)fluffy3).setName("fluffy3");
		//this throws a ClassCasteExeception
		//at runtime, the actual type is checked
		
		Cat c1 = new Cat(8, "paul");
		Cat c2 = new Cat(7, "peter");
		Dog d1 = new Dog();
		/*
		 * Arrays:
		 * Elements must be the same type, length must be specified
		 * 
		 */
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		for (int i = 0; i<animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		//best practices: refer to the static members via the class
		System.out.println(Cat.CatlatinName);
		
		//this will change the static field for ALL instances of dog
		Dog d2 = new Dog();
		//Dog.latinName = "dogus dogus";
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
		
		//fun with shadowing
		d2.setName("fido");
		System.out.println(d2.getName());
		
	}
}
