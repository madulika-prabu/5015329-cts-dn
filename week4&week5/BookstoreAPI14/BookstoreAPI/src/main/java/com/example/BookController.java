package com.example;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {



    @PostMapping("/books")
    public ResponseEntity<Bookentity> saveProduct(@RequestBody Bookentity book) {
        return ResponseEntity.ok().body(book);
    }


    @GetMapping("/books")
    public List<Bookentity> getAllProducts() {
        List<Bookentity> books = new ArrayList<>();
        return books;

    }




    @PutMapping("/books/{id}")
    public ResponseEntity<Bookentity> updateProduct(@PathVariable Long id, @RequestBody Bookentity book) {
        Bookentity updatedBook = book;
        return ResponseEntity.ok().body(updatedBook);
    }


    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body("Deleted");
    }

    @GetMapping("/books")
    public List<Bookentity> getBooks(@RequestParam(required = false) String title,@RequestParam(required = false) String author){
        List<Bookentity> books = new ArrayList<>();
        return books;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(1L);
        return customer;
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleIllegalArgumentException() {
        // illegal exception handler
    }

    @GetMapping("/customHeader")
    public ResponseEntity<String> customHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return new ResponseEntity<>("Custom header set", headers, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public Bookentity get_Customer_ById(@PathVariable String id) {
        Bookentity b = new Bookentity();
        b.setId(1L);
        b.setTitle("Title");
        b.setPrice(9.1);

        // Add self link
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).get_Book_ById(id)).withSelfRel();
        b.add(selfLink);

        return b;
    }

    private Class<?> get_Book_ById(String id) {
        //method
        return null;//return
    }


}
