package com.revature.dao;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.revature.beans.Bear;


public class BearDaoXMLImpl implements BearDao {
	
	private String docLocation = "src/BEars.xml";
			
	@Override
	public List<Bear> getBears() {
		// TODO Auto-generated method stub
		return readBearsSAX(docLocation);
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBear(Bear bear) {
		// TODO Auto-generated method stub

	}

	@Override
	public void feedBear(int bearId, int beehiveId, int honeyAmt) {
		// TODO Auto-generated method stub

	}
	
	private List<Bear> readBearsSAX(String filename) {
		
		
		
		return null;
	}

}
