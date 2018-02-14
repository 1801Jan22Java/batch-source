package com.revature.io;

import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class BearHandler extends DefaultHandler {
	
	public BearHandler() {
		super();
	}
	
	// Streaming an XML document
	// What we do at the start of an element
	@Override
	public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+": ");
		System.out.println("Attributes: "+attributes.getQName(0) + " = " + attributes.getValue(0));
	}
	// What we do at the end of an element
	@Override
	public void endElement(String uri, String localname, String qName) throws SAXException {
		System.out.println("// "+qName);
	}
	
	// What we do with the contents of an element
	
	
}
