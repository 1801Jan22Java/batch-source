package com.revature.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.revature.beans.Bear;
import com.revature.io.BearHandler;

public class BearDaoXMLImpl implements BearDao {
	
	private String docLocation = "src/Bears.xml";

	@Override
	public void feedBear(int bearID, int beehiveID, int amthoney) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bear> getBears() {
		return readBearsSAX(docLocation);
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}
	
	private  List<Bear> readBearsDOM(String filename)
	{
		List<Bear> bl = new ArrayList<>();
		
		return bl;
	}
	
	private List<Bear> readBearsSAX(String filename)
	{
		SAXParserFactory factory= SAXParserFactory.newInstance();
		SAXParser sp;
		try {
			sp=factory.newSAXParser();
			BearHandler handler = new BearHandler();
			sp.parse(filename, handler);
		}
		catch(Exception e)
		{e.printStackTrace();
		}
		return null;
		
	}
	
	public Bear unmarshallBear(String filename) 
	{
		Bear b= null;
		try {
			File file = new File(filename);
			JAXBContext jxbc =JAXBContext.newInstance(Bear.class);
			Unmarshaller jxbu= jxbc.createUnmarshaller();
			b = (Bear) jxbu.unmarshal(file);
		}
		catch(JAXBException e) 
		{
			e.printStackTrace();
		}
		return b;
		
	}
	
}
