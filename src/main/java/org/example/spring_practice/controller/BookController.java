package org.example.spring_practice.controller;

import org.example.spring_practice.exception.InvalidIsbnException;
import org.example.spring_practice.exception.InvalidPublishedDateException;
import org.example.spring_practice.exception.InvalidTitleException;
import org.example.spring_practice.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> findAll() {
        return books;
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        if (book.getIsbn() == null || book.getIsbn().isBlank()) {
            throw new InvalidIsbnException("isbn не может быть пустым или null");
        } else if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new InvalidTitleException("title не может быть пустым или null");
        } else if (book.getPublishedDate() == null || book.getPublishedDate().isAfter(LocalDate.now())) {
            throw new InvalidPublishedDateException("день публикаций не может быть в будущем или null");
        }

        books.add(book);
        return book;
    }
}
