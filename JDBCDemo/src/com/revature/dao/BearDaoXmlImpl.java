package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.revature.beans.Bear;
import com.revature.io.BearHandler;

public class BearDaoXmlImpl implements BearDao {
	// initialize document location, where our xml file is located
	private String docLocation = "src/Bears.xml";

	@Override
	public List<Bear> getBears() {
		//return readBearsSAX(docLocation);
		return readBearsDOM(docLocation);
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buildABear(Bear bear) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int feedBear(int bearId, int hiveId, int amt) {
		// TODO Auto-generated method stub
		return 0;
	}

	private List<Bear> readBearsSAX(String filename) {
		SAXParserFactory factory =  SAXParserFactory.newInstance();
		
		SAXParser sp;
		
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
}
