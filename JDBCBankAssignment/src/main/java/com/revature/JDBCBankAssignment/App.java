package com.revature.JDBCBankAssignment;

public class App 
{
    public static void main( String[] args )
    {
    	Banker banker = new Banker();
    	
    	//Start a banker!
    	if(banker.init()) {
    		banker.run();
    	}
        
    }
}
