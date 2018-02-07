package com.revature.oop;

public class FunWithOop {
	
	public static void main(String[] args) {
		
		//create a new Animal
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		//polymorphic instance method: toString
		//cannot access animal's name -> because it is set as an Object
		Object fluffy2 = new Animal(); //implicit upcasting -> can see an animal as an Object, but is still an Animal
		
		//need to cast the Object as an Animal
		//cannot implicitly downcast -> cannot see object as an animal so you must explicitly cast
		// when you call fuffly2.toString we get the animal version because at the base the object is still an Animal because of declaration
		((Animal) fluffy2).setName("fluffy2"); 
		System.out.println(fluffy2.toString());
		
		//at compile time, the declared type is checked.
		//casts can work (at compile time) up or down the inheritance tree
		
		//Object fluffy3 = new Object();
		//((Animal)fluffy3).setName("fluffy3"); // this will result in class cast exception
		
		Cat c1 = new Cat(9,"Roberto");
		Cat c2 = new Cat(7,"Peter");
		Dog d1 = new Dog();
		
		/*
		 * Arrays:
		 * Elements must be the same type, length must be specified
		 * length is immutable (contiguous block of memory is allocated)
		 * java.util.Arrays (note the s) for useful methods
		 * all elements are set to default value for that data type
		 */
		
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		for (int i = 0; i < animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		// BEST PRACTICES: refer to the static members of the class instead of the instances
		System.out.println(Cat.catinName);
		
		Dog d2 = new Dog();
		
		// CHANGES all static variables if it is not final
//		d2.latinName = "poopy mcpoop";
		
		System.out.println("doge latin name " + Dog.latinName);
	}

}
