package com.revature.dao;

import java.util.List;

import javax.xml.parsers.SAXParser;

import com.revature.beans.Bear;
import com.revature.io.BearHandler;

public class BearDaoXmlImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildABear(int type, String name, int caveId, int weight, String birthdate) {
		// TODO Auto-generated method stub

	}
	
	private List<Bear> readBearsSAX(String filename) {
		
		SAXParserFactory factory = new SAXParserFactory.newInstance();
		
		SAXParser sp;
		
		try {
			sp = factory.newSAXParser();
			BearHandler handler = new BearHandler();
			sp.parse(filename, handler);
		} catch()
		
		return null;
	}

}
