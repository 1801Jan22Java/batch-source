package com.Practice_work.Generics;

import java.util.Arrays;

public class TestOne {

	public static void arraySort() {
		String[] fruits = new String[] { "Pineapple", "Apple", "Orange", "Banana" };

		Arrays.sort(fruits);

		int i = 0;

		for (String temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp);
		}
	}

	public static void fruitsSort() {
		Fruit[] fruits = new Fruit[4];

		Fruit pineapple = new Fruit("Pineapple", "Pineapple description", 70);
		Fruit apple = new Fruit("Apple", "Apple description", 100);
		Fruit orange = new Fruit("Orange", "Orange description", 80);
		Fruit banana = new Fruit("Banana", "Banana description", 90);

		fruits[0] = pineapple;
		fruits[0] = apple;
		fruits[0] = orange;
		fruits[0] = banana;
		
		Arrays.sort(fruits);
		
		int i = 0;
		
		for(Fruit temp : fruits) {
			System.out.println("fruits" + ++i + " : " + temp.getFruitName()+ ", Quantity : "+ temp.getQuantity());
		}
	}
	public static void fruitsSortComparable() {
		ComparableFruit[] fruits2 = new ComparableFruit[4];

		ComparableFruit pineapple = new ComparableFruit("Pineapple", "Pineapple description", 70);
		ComparableFruit apple = new ComparableFruit("Apple", "Apple description", 100);
		ComparableFruit orange = new ComparableFruit("Orange", "Orange description", 80);
		ComparableFruit banana = new ComparableFruit("Banana", "Banana description", 90);

		fruits2[0] = pineapple;
		fruits2[1] = apple;
		fruits2[2] = orange;
		fruits2[3] = banana;
		
		Arrays.sort(fruits2);
		
		int i = 0;
		
		for(ComparableFruit temp : fruits2) {
			System.out.println("fruits" + ++i + " : " + temp.getFruitName()+ ", Quantity : "+ temp.getQuantity());
		}
	}

	public static void main(String[] args) {
		// this fails because the comparable method 
		// has no way to sort the objects 
		// we need to implement the comparable method 
		// and tell it how to sort the fruits 
		// by overriding compart To
		//fruitsSort();
		
		fruitsSortComparable();
		

	}

}
