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
    public Book create(@RequestBody Book book) throws InvalidIsbnException, InvalidTitleException, InvalidPublishedDateException {
        if (book.getIsbn().isBlank() || book.getIsbn().equals(null)) {
            throw new InvalidIsbnException("isbn не может быть пустым или null");
        } else if (book.getTitle().isBlank() || book.getTitle().equals(null)) {
            throw new InvalidTitleException("title не может быть пустым или null");
        } else if (book.getPublishedDate().isAfter(LocalDate.now()) || book.getPublishedDate().equals(null)) {
            throw new InvalidPublishedDateException("день публикаций не может быть в будущем или null");
        }

        books.add(book);
        return book;
    }
}
