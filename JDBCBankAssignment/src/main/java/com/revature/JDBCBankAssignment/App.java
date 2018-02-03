package com.revature.JDBCBankAssignment;

import com.revature.util.ConnectionUtil;

/**
 * Hello world!
 *
 */
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
