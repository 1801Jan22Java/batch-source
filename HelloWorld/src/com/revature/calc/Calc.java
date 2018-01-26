package com.revature.calc;

public class Calc {
	public static int add(int first, int second) {
		return first + second;
	}
	public static Number addWithoutGenerics(Number n1, Number n2) {
		return (Double) n1 + (Double)n2;
	}
	public static <T> Number addWithGenerics(T n1, T n2) {
		Number result = null;
		if (n1 instanceof Double) {
			result = ((Double) n1).doubleValue() + ((Double) n2).doubleValue();
		}
		return result;
	}
	public static double add(double first, double second) {
		return first + second;
	}
	public static int subtract(int first, int second) {
		return first - second;
	}
	public static double subtract(double first, double second) {
		return first - second;
	}
	public static int multiply(int first, int second) {
		return first * second;
	}
	public static double multiply(double first, double second) {
		return first * second;
	}
	public static int divide(int first, int second) {
		return first / second;
	}
	public static double divide(double first, double second) {
		return first / second;
	}
}
