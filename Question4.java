package com.revature.homework1;

class Question4{
    
    public static void main(String[] args){
        
    }   
    
    static int factorial(int number){
        if (number == 0)
        	return 1;
        else
        	return factorial(number - 1) * number;
    }
}