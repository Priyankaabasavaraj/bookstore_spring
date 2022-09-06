package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;


@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public Book addBook(@RequestBody Book book)
	{
		return  bookService.save(book);
	}
	
	@GetMapping(path ="/{id}")
	public Book getBook(@PathVariable int id)
	{
		return  bookService.getBook(id);
	}
	
	@PutMapping()
	public Book updateBook(@RequestBody Book book)
	{
		return  bookService.update(book);
	}
	
	@DeleteMapping(path ="/{id}")
	public String deleteBook(@PathVariable int id)
	{
		return  bookService.delete(id);
	}

	public BookService getBookService() {
		return  bookService;
	}

	public void setBookService(BookService  bookService) {
		this. bookService =  bookService;
	}
	
	

}
