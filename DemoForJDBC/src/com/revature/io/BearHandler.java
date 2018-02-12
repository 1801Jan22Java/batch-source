package com.revature.io;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class BearHandler extends DefaultHandler {

	public BearHandler() {
		super();
	}
	
	@Override 
	public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException{
		System.out.println(qName+": ");
		System.out.println("attributes: "+attributes.getQName(0) + " = " + attributes.getQName(1));
	}
	
	
}
