package com.Practice_work.Generics;

import java.util.ArrayList;
import java.util.Collections;

public class Comparable2Driver {
	
	public static void main(String[] args) {
		ArrayList<Languages> lang = new ArrayList<>();
		lang.add(new Languages("Spanish","Mexico"));
		lang.add(new Languages("Korean","Korea"));
		lang.add(new Languages("Portugese","Brazil"));
		lang.add(new Languages("French","France"));
		
		for(Languages l : lang) {
			System.out.println(l.toString());
		}
		Collections.sort(lang,new SortBycountry());
		System.out.println("sorted");
		for(Languages l : lang) {
			System.out.println(l.toString());
		}
		
	}

}
