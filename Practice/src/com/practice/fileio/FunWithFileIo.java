package com.practice.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FunWithFileIo {
	static File file = new File("test.txt");

	public static void writingExternalTextFile() {
		

		// writing name and age to the file

		try {

			FileWriter output = new FileWriter(file);
			output.write("Calder Jones 28");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readingFile() {
		try {
		Scanner in = new Scanner(file);
		String name = in.nextLine();
		int age = in.nextInt();
		System.out.print(name +" "+ age);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
			writingExternalTextFile();
	}

}