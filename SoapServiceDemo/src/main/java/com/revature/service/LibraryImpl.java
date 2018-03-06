package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exception.BradburyException;
import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library {

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("Old Man's War","John Scalzi",2005));
		bookList.add(new Book("Ghost Brigades","John Scalzi",2006));
		bookList.add(new Book("Jurassic Park","Michael Chrichton",1990));
		return bookList;
	}

	@Override
	public String addBook(Book book) throws BradburyException {
		//not really doing anything in particular
		if (book.getTitle().equals("Farenheit 451")){
			throw new BradburyException();
		}
		return "successfully added "+book.getTitle();
	}

}
