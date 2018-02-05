package com.revature.util;

import java.util.List;

import com.revature.beans.Bankuser;
import com.revature.dao.*;

public class CheckUtilities {
	
	public static boolean containsString(String str,String field, BankuserDao bd) {
		
		List<Bankuser> resultBankusers = bd.getBankusers();
		
		for (Bankuser b : resultBankusers) {
			
			if (field.equals("pass")) {
				
				if (str.equals(b.getPassword())) {
					return true;
				}
			}
			else {
				
				if (str.equals(b.getBankuser())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean checkUser(String username,BankuserDao bd) {
		
		if (containsString(username,"user",bd)) {
			return true;
		}
		
		return false;
	}

	public static boolean checkPassword(String password,BankuserDao bd) {
		
		if (containsString(password,"pass",bd)) {
			return true;
		}
		
		return false;
	}


}
