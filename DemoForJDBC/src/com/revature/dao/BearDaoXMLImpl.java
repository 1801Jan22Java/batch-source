package com.revature.dao;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.revature.beans.Bear;
import com.revature.io.BearHandler;

public class BearDaoXMLImpl implements BearDao {

	private String docLocation = "src/Bears.xml";
		
	private List<Bear> readBearsSax(String filename){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser sp;
		try {
			sp = factory.newSAXParser();
			BearHandler handler = new BearHandler();
			sp.parse(filename, handler);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void feedBear(int bearID, int beehive, int honeyAmt) {
		// TODO Auto-generated method stub

	}

	public List<Bear> getBears() {
		// TODO Auto-generated method stub
		return null;
	}

	public Bear getBearByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
