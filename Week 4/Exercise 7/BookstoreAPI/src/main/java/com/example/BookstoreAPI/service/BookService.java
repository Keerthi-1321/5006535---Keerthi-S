package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private int nextId = 1;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookDTO getBookById(int id) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
        return bookMapper.bookToBookDTO(book);
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        book.setId(nextId++);
        books.add(book);
        return bookMapper.bookToBookDTO(book);
    }

    public void deleteBook(int id) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
        books.remove(book);
    }
}
