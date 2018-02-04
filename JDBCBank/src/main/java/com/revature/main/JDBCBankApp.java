package com.revature.main;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import com.revature.dao.*;

public class JDBCBankApp {

	public static void main(String[] args) {
		
		Reader rdr = new InputStreamReader(System.in);
		PrintWriter wtr = new PrintWriter( System.out );
		UserDAO ud = new UserDAOImpl();
		AccountDAO ad = new AccountDAOImpl();
		
		
		BankDTO bdto = new BankDTOImpl(ud, ad, wtr);
		
		Bank bank = new Bank(rdr, wtr, bdto);
		
		bank.startBank();

	}

}
