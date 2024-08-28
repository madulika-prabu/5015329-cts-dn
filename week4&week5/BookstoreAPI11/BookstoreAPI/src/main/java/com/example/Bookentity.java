package com.example;


import jakarta.persistence.*;
import org.springframework.hateoas.Link;

@Entity
@Table(name = "product")
public class Bookentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String isbn;



    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(String isbn) {
        this.isbn = isbn;
    }

    public void add(Link selfLink) {
        
    }
}
