package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Load the Spring context from the XML configuration file

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration
        bookService.printMessage();
    }
}


