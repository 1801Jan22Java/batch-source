package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.BradburyException;
import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library {

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addBook(Book book) throws BradburyException {
		// TODO Auto-generated method stub
		return null;
	}

}
