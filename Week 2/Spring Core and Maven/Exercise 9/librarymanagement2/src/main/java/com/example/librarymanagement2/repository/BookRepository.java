package com.example.librarymanagement2.repository;

import com.example.librarymanagement2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
