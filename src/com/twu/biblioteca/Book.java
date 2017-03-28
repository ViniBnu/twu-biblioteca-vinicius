package com.twu.biblioteca;


import java.time.LocalDate;

/**
 * Created by vsolive on 28/03/17.
 */
public class Book {
    private String name;
    private String author;
    private Integer releaseYear;

    public Book(String name, String author, Integer releaseYear) {
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
    }
}
