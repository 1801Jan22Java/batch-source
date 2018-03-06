package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.BradburyException;
import com.revature.model.Book;

@WebService
public interface Library {
	
	//we could also generate this file from the WSDL exposed in our SoapServiceDemo
	
	public List<Book> getAllBooks();
	public String addBook(Book book) throws BradburyException;
	public void notARealMethod();
	

}
