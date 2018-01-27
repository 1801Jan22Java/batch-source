package com.practice.fileio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StoreDriver {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("students.txt");

		ArrayList<Stores> store = new ArrayList<>();
		store.add(new Stores(3, "walmart", "general"));
		store.add(new Stores(2, "aldies", "grocery"));
		store.add(new Stores(1, "carsons", "clothing"));
		// serialize the collection of students

		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(fo);

		for (Stores s : store) {
			output.writeObject(s);
		}
		output.close();
		fo.close();

		// deserialize the file back into the collection

		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream input = new ObjectInputStream(fi);

		ArrayList<Stores> store2 = new ArrayList<>();
		try {
			while (true) {
				Stores s = (Stores) input.readObject();
				store2.add(s);

			}
		} catch (EOFException e) {

		}
		
		for(Stores m: store2) {
			System.out.print(m.toString());
		}

	}
}
