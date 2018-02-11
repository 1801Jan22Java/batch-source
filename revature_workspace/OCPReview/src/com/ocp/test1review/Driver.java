package com.ocp.test1review;

import java.util.stream.Stream;


abstract class Widget {
	String data="data";
	public void doWidgetStuff() {}	
}

class GoodWidget extends Widget 
{
	String data = "big data";
	public void doWidgetStuff() {
		System.out.println(data);
	}
}
public class Driver {

	public static void main(String[] args) {
		Stream<String> names = Stream.of("sarah adams","suzy pinnell","paul basgall");
		Stream<String> firstNames = names.map(e->e.split(" ")[0]);
	//	Stream<String> firstNames2 = names.filter(e->e=="sarah");
	//	String[] firstNameArray=(String[]) firstNames.toArray();
		
		Widget w = new GoodWidget();
		w.doWidgetStuff();
		System.out.println(w.data);
	}
	
	

}
