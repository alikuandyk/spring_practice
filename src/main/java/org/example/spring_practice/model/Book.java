package org.example.spring_practice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Book {
    private String isbn;
    private String title;
    private String author;
    private LocalDate publishedDate;
}
