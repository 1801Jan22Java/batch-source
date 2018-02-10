package com.revature.io;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class BearHandler extends DefaultHandler
{
	public BearHandler()
	{
		super();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		System.out.println(qName+": ");
		System.out.println("Attributes: "+attributes.getQName(0)+" = "+attributes.getValue(0));
	}
	
	public void endElement("");
}
