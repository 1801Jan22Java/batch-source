package com.revature.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.io.BearHandler;

public class BearDaoXmlImpl implements BearDao {
	
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
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser sp;
		
		try {
			sp = factory.newSAXParser();
			BearHandler handler = new BearHandler();
			sp.parse(filename, handler);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	private List<Bear> readBearsDOM(String filename) {
		List<Bear> bl = new ArrayList<>();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {

			db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(filename);
			doc.getDocumentElement().normalize();
			// prints "bears"- root element name
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList bearList = doc.getElementsByTagName("bear");
			for (int i = 0; i < bearList.getLength(); i++) {
				Bear newBear = new Bear();
				Cave newCave = new Cave();
				BearType newType = new BearType();
				Node bear = bearList.item(i);
				newBear.setId(Integer.parseInt(bear.getAttributes().item(0).getNodeValue()));
				System.out.println("\t" + bear.getNodeName());
				NodeList children = bear.getChildNodes();
				for (int j = 0; j < children.getLength(); j++) {
					Node child = children.item(j);
					if (child.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("\t\t" + child.getNodeName() + " : " + child.getTextContent());
						if (child.getNodeName().equals("name")) {
							newBear.setName(child.getTextContent());
						}
						if (child.getNodeName().equals("weight")) {
							newBear.setWeight(Integer.parseInt(child.getTextContent()));
						}
						if (child.getNodeName().equals("cave")) {
							newCave.setId(Integer.parseInt(child.getAttributes().item(0).getNodeValue()));
						}

						NodeList grandchildren = child.getChildNodes();
						for (int k = 0; k < grandchildren.getLength(); k++) {
							Node grandchild = grandchildren.item(k);
							if (grandchild.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println(

										"\t\t" + grandchild.getNodeName() + " : " + grandchild.getTextContent());
								String s = grandchild.getNodeName();
								System.out.println(s);
								if (grandchild.getNodeName().equals("cName")) {
									System.out.println("found name");
									newCave.setName(grandchild.getTextContent());
								}
								if (grandchild.getNodeName().equals("maxBears")) {
									newCave.setMaxBears(Integer.parseInt(grandchild.getTextContent()));
								}
							}
						}
					}

				}
				newBear.setCave(newCave);
				newBear.setBearType(newType);
				bl.add(newBear);
			}
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bl;
	}
	
	public Bear unmarshalBear(String filename) {
		Bear b = null;
			try {
				File file = new File(filename);
				JAXBContext jxbc = JAXBContext.newInstance(Bear.class);
				Unmarshaller jxbu = jxbc.createUnmarshaller();
				b = (Bear) jxbu.unmarshal(file);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		return b;
	}

}


