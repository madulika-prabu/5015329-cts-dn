package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.assembler.BookModelAssembler;
import com.example.bookstore.controller.BookController;
import com.example.bookstore.service.BookService;
import com.example.bookstore.entity.*;
import com.example.bookstore.exception.*;

import org.mapstruct.ap.shaded.freemarker.ext.beans.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;
    private final BookModelAssembler assembler;

    public BookController(BookRepository bookRepository, BookModelAssembler assembler) {
        this.bookService = null;
		this.bookRepository = bookRepository;
        this.assembler = assembler;
    }
    @GetMapping("/{id}")
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        return assembler.toModel(book);
    }

    @GetMapping
    public CollectionModel getAllBooks() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withSelfRel();
        return CollectionModel.of(books, selfLink);
    }

	@PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
