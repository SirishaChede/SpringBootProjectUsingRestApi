package com.example.demo.RestAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RestAPI.Entity.BookEntity;
import com.example.demo.RestAPI.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookService bookservice;
	@GetMapping
	public List<BookEntity> getAllBooks() {
		return bookservice.getAllBooks();
	}
	@GetMapping("/{id}")
	public Optional<BookEntity> getBookById(@PathVariable("id") int bookid) {
	   return bookservice.getBookById(bookid);
	    
	}
	@PostMapping
	public int saveall(@RequestBody BookEntity book) {
		bookservice.saveOrUpdate( book);
		return book.getBookid();
	}
	@PutMapping("/{id}")  
	private BookEntity update(@PathVariable int id ,@RequestBody BookEntity books)   
	{  
	bookservice.saveOrUpdate(books);  
	return books;  
	} 
	@DeleteMapping("/{id}")
	public String deletebook(@PathVariable int id) {
        boolean isDeleted = bookservice.deleteBook(id);
        return isDeleted ? "book deleted successfully!" : "book not found!";
    }

}
