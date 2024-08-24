package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class BookDTO {
    private int id;
    private String title;
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ISBN ###-##-####")
    private String isbn;
}

