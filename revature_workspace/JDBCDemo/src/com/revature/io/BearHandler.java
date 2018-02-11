package com.revature.io;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class BearHandler extends DefaultHandler {
	public BearHandler() {
		super();
	}
	
	//what to do at start of element
	@Override
	public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException
	{
		System.out.println(qName +" : ");
		System.out.println("attributes: " + attributes.getQName(0)+ " = "+attributes.getValue(0));
	}
	
	//what to do at end of element
	@Override
	public void endElement(String uri, String localname, String qName) throws SAXException
	{
		System.out.println();
	}
	
	//what to do with the contents of an element.

}
