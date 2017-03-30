package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vsolive on 28/03/17.
 */
public class Library {

    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public List<Book> getAvailableBooks() {
        return books.stream().filter(b -> b.isAvailable()).collect(Collectors.toList());
    }

    public void showAllBooksAvailable() {
        getAvailableBooks().forEach(System.out::println);
    }

}
