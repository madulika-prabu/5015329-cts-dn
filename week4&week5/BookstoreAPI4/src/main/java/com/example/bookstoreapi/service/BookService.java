package com.example.bookstoreapi.service;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Method to retrieve all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();  // Make sure the repository is correctly autowired
    }

    // Method to retrieve a book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Method to save a new or updated book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Method to delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

