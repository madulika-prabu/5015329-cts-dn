package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        // Load the Spring context from the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve the 'bookService' bean
        BookService bookService = context.getBean(BookService.class);
        
        // Use the 'bookService' to add a new book
        bookService.addBook("To Kill a Mockingbird");
        
        // Close the application context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
