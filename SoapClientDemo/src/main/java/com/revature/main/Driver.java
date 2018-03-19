package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.exception.BradburyException;
import com.revature.model.Book;
import com.revature.service.Library;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class Driver {

	public static void main(String... args) {
		Library library = getLibrary();
		
		
		List<Book> bl = library.getAllBooks();
		for (Book b : bl) {
			System.out.println();
		}
		
		GlobalWeatherSoap gws = new GlobalWeather().getGlobalWeatherSoap();
		System.out.println(gws.getCitiesByCountry("United States"));
				
		// add book to library
		/*
		Book newBook = new Book("Fahrenheit 451", "Ray Bradbury", 1953); //new Book("Dune", "Frank Herbert", 1965);
		try {
			System.out.println(library.addBook(newBook));
		} catch(BradburyException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
	static Library getLibrary() {
		
		// If only we had a FRAMEWORK TO INJECT THESE DEPENDENCIES
		// maybe hold them in a CONTAINER OR CONTEXT...
		
		String serviceUrl = "http://localhost:8080/SoapServiceDemo/Library";
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceUrl);
		
		// Set up interceptors for SOAP messages
		LoggingInInterceptor inInt = new LoggingInInterceptor();
		LoggingOutInterceptor outInt = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInt);
		factory.getOutInterceptors().add(outInt);
		inInt.setPrintWriter(new PrintWriter(System.out));
		outInt.setPrintWriter(new PrintWriter(System.out));
		
		return (Library) factory.create();
	}
	
}
