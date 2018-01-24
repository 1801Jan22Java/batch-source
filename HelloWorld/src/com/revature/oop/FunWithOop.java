package com.revature.oop;

public class FunWithOop {
	public static void main(String[] args) {
		// create a new Animal
		Animal fluffy = new Animal();
		System.out.println(fluffy.getName());
		
		Object fluffy2 = new Animal();
		System.out.println(((Animal)fluffy2).getName());
		
		Cat c1 = new Cat(8, "Paul");
		Dog d1 = new Dog();
		Cat c2 = new Cat(7, "Peter");
		
		Animal[] animals = new Animal[3];
		animals[0] = c1;
		animals[1] = c2;
		animals[2] = d1;
		
		for (int i = 0; i < animals.length; i++) {
			animals[i].makeNoise();
		}
		
		Dog d2 = new Dog();
		Dog.latinName  = "doggus doggus";
		
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
	}
	
}
