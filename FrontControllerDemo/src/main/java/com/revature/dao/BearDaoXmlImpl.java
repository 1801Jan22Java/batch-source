package com.revature.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;

import com.revature.beans.Bear;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import com.sun.xml.internal.ws.wsdl.writer.DocumentLocationResolver;

import IO.BearHandler;
import oracle.net.aso.b;

public class BearDaoXmlImpl implements BearDao {

	private String docLocation = "src/Bears.xml";

	@Override
	public List<Bear> getBears() {
		// return readBearsSAX(docLocation);
		return readBearsDOM(docLocation);
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Bear> readBearsSAX(String filename) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		javax.xml.parsers.SAXParser sp;

		try {
			sp = factory.newSAXParser();
			BearHandler handler = new BearHandler();
			sp.parse(filename, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Bear> readBearsDOM(String filename) {
		List<Bear> bl = new ArrayList<>();

		return bl;
	}

	public Bear unmarshalBear(String filename) {
		Bear bear = null;

		try {
			File file = new File(filename);
			JAXBContext jxbc = JAXBContext.newInstance(Bear.class);
			Unmarshaller jxbu = jxbc.createUnmarshaller();
			bear = (Bear) jxbu.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return bear;
	}
}
