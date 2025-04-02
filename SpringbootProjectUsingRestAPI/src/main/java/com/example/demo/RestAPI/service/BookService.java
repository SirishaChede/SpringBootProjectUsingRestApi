package com.example.demo.RestAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.RestAPI.Entity.BookEntity;
import com.example.demo.RestAPI.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create or Update Book
    public BookEntity saveOrUpdate(BookEntity book) {
        return bookRepository.save(book);
    }

    // Get a single Book
    public Optional<BookEntity> getBookById(int bookid) {
        return bookRepository.findById(bookid);
    }

    // Get all Books
    //@Transactional
    public List<BookEntity> getAllBooks() {
        return  (List<BookEntity>) bookRepository.findAll();
    }

    // Delete a Book
    public boolean deleteBook(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}