package com.ocp.chapter2;

import java.util.function.Predicate;

public class FindMatchingAnimals2 {
	
	private static void print(Animal animal, Predicate<Animal> trait)
	{
		if(trait.test(animal)) System.out.println(animal);
	}
	
	public static void main(String [] args)
	{
		print(new Animal("Magikarp", false, true), a-> a.canHop());
		print(new Animal("Scyther",true,false), a-> a.canHop());
	}
	
	
}
