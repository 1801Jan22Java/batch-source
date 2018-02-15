package IO;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class BearHandler extends DefaultHandler {
	public BearHandler() {
		super();
	}

	// What to do at start of an element
	@Override
	public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+": ");
		System.out.println("attributes: "+ attributes.getQName(0)+" = " +attributes);
	}

	// What to do at end of an element
	@Override
	public void endElement(String uri, String localname, String qName) throws SAXException {
		System.out.println(qName+": ");
	}
	// What to do with contents of an elements

}
