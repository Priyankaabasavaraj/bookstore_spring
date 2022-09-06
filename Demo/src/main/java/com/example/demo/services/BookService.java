package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public Book save(Book emp)
	{
		return bookRepository.save(emp);   // to store the data
	}
	
	public Book getBook(int id)
	{
		return bookRepository.findById(id).get();
	}
	
	public Book update(Book book) 
	{
		Book emp= bookRepository.findById(book.getId()).get();
		emp.setBookName(book.getBookName());
		emp.setAuthorName(book.getAuthorName());
		
		return bookRepository.save(emp);
	}
	
	public String delete(int id)
	{
		bookRepository.deleteById(id);
		return "Entity deleted "+id;
	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

}
