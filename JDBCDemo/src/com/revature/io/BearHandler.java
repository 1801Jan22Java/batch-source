package com.revature.io;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.xml.sax.helpers.DefaultHandler;

public class BearHandler extends DefaultHandler {
	
	public BearHandler() {
		super();
	}
	
	// what to do at the start of an element
	@Override
	public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + ": ");
		System.out.println("attributes: " + attributes.getQName(0) + " = " + attributes.getValue(0));
	}
	
	// what to do at the end of an element
	@Override
	public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException {
		System.out.println("//" + qName);
		
	}
	// what todo with the contents of an element
}
