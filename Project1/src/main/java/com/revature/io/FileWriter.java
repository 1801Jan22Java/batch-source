package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.revature.beans.*;

public class FileWriter {
	
	public static void writeSingleEmployee(String filename, Employee emp) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw = new PrintWriter(filename, "UTF-8");
		pw.println(emp.toString());
		pw.close();
	}
	
	public static void writeSingleManager(String filename, Manager mgr) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw = new PrintWriter(filename, "UTF-8");
		pw.println(mgr.toString());
		pw.close();
	}

	public static void writeFiles(String filename, List<Reimb> reimbs) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter pw = new PrintWriter(filename, "UTF-8");
		String str = "{ \"allReimbs\" : [ ";
		for (int i = 0; i < reimbs.size(); i++) {
			if (i == reimbs.size() - 1) {
				str = str + reimbs.get(i).toString();
			} else {
				str = str + reimbs.get(i).toString() + ", ";
			}
		}
		str += "] }";
		pw.println(str);
		pw.close();
		
	}
	
	public static void writeEmployees(String filename, List<Employee> emps) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw = new PrintWriter(filename, "UTF-8");
		String str = "{ \"allEmps\" : [ ";
		for (int i = 0; i < emps.size(); i++) {
			if (i == emps.size() - 1) {
				str = str + emps.get(i).toString();
			} else {
				str = str + emps.get(i).toString() + ", ";
			}
		}
		str += "] }";
		pw.println(str);
		pw.close();
	}
	
	public static void imageWriter(String filename, byte[] bytes) throws IOException {
		OutputStream out = new FileOutputStream(filename);
		out.write(bytes);
		out.flush();
		out.close();
	}
	
}
