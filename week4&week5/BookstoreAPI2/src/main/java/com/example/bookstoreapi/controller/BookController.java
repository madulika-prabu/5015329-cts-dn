package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    // In-memory list to simulate a database
    private List<Book> books = new ArrayList<>();

    // Constructor to add some sample books
    public BookController() {
        books.add(new Book(1L, "Effective Java", "Joshua Bloch", 45.99, "978-0134685991"));
        books.add(new Book(2L, "Clean Code", "Robert C. Martin", 39.99, "978-0132350884"));
        books.add(new Book(3L, "Spring in Action", "Craig Walls", 49.99, "978-1617294945"));
    }

    // 1. Endpoint to fetch a book by its ID using a path variable
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    // 2. Endpoint to filter books based on query parameters like title and author
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        return books.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .collect(Collectors.toList());
    }
}
