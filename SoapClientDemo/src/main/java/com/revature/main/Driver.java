package com.revature.main;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.service.Library;

public class Driver {

	public static void main(String[] args) {
		Library library = getLibrary();
		System.out.println(library.getAllBooks());
	}

	static Library getLibrary() {
		
		//if only we had a FRAMEWORK TO INJECT THESE DEPENDENCIES
		//maybe hold them in a CONTAINER OR CONTEXT.... 

		String serviceUrl = "http://localhost:8084/SoapServiceDemo/Library";

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceUrl);

		return (Library) factory.create();

	}
}
