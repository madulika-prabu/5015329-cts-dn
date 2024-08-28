package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // query method to find books by title
    List<Book> findByTitle(String title);

    // query method to find books by author
    List<Book> findByAuthor(String author);

    // Custom query method using @Query to find books within a price range
    @Query("SELECT b FROM Book b WHERE b.price BETWEEN :minPrice AND :maxPrice")
    List<Book> findBooksInPriceRange(Double minPrice, Double maxPrice);

    // Custom query method to find books by ISBN
    @Query("SELECT b FROM Book b WHERE b.isbn = :isbn")
    Book findByIsbn(String isbn);
}

