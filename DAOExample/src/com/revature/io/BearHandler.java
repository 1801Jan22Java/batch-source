package com.revature.io;

import org.xml.sax.*;
import org.xml.sax.helpers.*;


public class BearHandler extends DefaultHandler{

	public BearHandler() {
		super();
	}
	
	//what to do at the start of an element
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		System.out.println(qName+": ");
		System.out.println("attributes: "+attributes.getQName(0)+ " = " + attributes.);
	}
	//what to do at the end of an element
	//what to do with the contents of an element
}
