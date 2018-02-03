package com.revature.JDBCBank;


import java.util.Scanner;

import com.revature.model.UserActions;

public class App 
{
	private static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	UserActions.mainMenu(sc);
        sc.close();  
    }
    
}

