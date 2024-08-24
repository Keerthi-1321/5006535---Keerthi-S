package com.example.BookstoreAPI.model;

import lombok.Data;

@Data
public class Book {
    private int id;  // Using int for the id field
    private String title;
    private String author;
    private String isbn;
}
