package com.revature.homework1;

public abstract class Question18 {
	
	abstract static class SuperClass{
		
		
		public abstract boolean hasUppercase(String str);
		
		public abstract String upperToLower(String str);
		
		
		public abstract int addTen(String num);
		}
	
	public static class SubClass extends SuperClass{

		@Override
		public boolean hasUppercase(String str) {
			char[] charArray = str.toCharArray();
			boolean booleanValue = false;
			for(int i = 0; i < charArray.length;i++) {
				if(Character.toString(charArray[i]).equals(Character.toString(charArray[i]).toUpperCase())) {
					booleanValue = true;
				}
			}
			

			return booleanValue;
		}

		@Override
		public String upperToLower(String str) {
			// TODO Auto-generated method stub
			return str.toLowerCase();
		}

		@Override
		public int addTen(String numString) {
			int sum = Integer.parseInt(numString);
			sum += 10;
			return sum;
		}
		
	}
	
	public static void tester() {
		// creates an instance of the SubClass and performs the operator methods on it
		SubClass t1 = new SubClass();
		System.out.println(t1.addTen("12"));
		System.out.println(t1.upperToLower("UPPER"));
		System.out.println(t1.hasUppercase("One"));
		System.out.println(t1.hasUppercase("one"));
		
		
		
	}
	
	public static void main(String[] args){
		
		tester();
	}
	
	
		

	}


