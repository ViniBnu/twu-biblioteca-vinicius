package com.twu.biblioteca;

import java.util.List;

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

    public List<Book> getBooks() {
        return books;
    }


}
