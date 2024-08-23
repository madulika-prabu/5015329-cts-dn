package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // In-memory list to store books (for simplicity)
    private List<Book> books = new ArrayList<>();

    // Method to handle GET requests for all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // Method to handle GET requests for a specific book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null); // In a real application, you would handle this case properly
    }

    // Method to handle POST requests to create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId((long) (books.size() + 1)); // Simulate setting an ID (in a real application, this would be handled by the database)
        books.add(book);
        return book;
    }

    // Method to handle PUT requests to update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book existingBook = books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setIsbn(updatedBook.getIsbn());
            return existingBook;
        } else {
            return null; // In a real application, you would handle this case properly
        }
    }

    // Method to handle DELETE requests to remove a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
