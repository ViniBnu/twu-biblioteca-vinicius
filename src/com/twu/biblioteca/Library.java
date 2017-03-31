package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private List<Book> availableBooks;
    private List<Book> unavailableBooks;

    public Library(List<Book> books, List<Book> checkedOutBooks) {
        this.availableBooks = books;
        this.unavailableBooks = checkedOutBooks;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<Book> getUnavailableBooks() {
        return unavailableBooks;
    }

    public boolean canChangeStatus(String bookName, List<Book> list) {
        Book book = searchBookByName(bookName);
        if (book == null || list.contains(book)) {
            return false;
        }
        return true;
    }


    public void checkinBook(String bookName) {
        Book book = searchBookByName(bookName);
        unavailableBooks.remove(book);
        availableBooks.add(book);
    }

    public void checkoutBook(String name) {
        Book book = searchBookByName(name);
        availableBooks.remove(book);
        unavailableBooks.add(book);
    }

    public Book searchBookByName(String bookName) {
        Book book = null;
        for(Book b : getAllBooks()) {
            if (b.getName().toLowerCase().equals(bookName.toLowerCase())) {
                book = b;
                break;
            }
        }
        return book;
    }

    private List<Book> getAllBooks() {
        List <Book> books = new ArrayList<Book>();
        books.addAll(availableBooks);
        books.addAll(unavailableBooks);
        return books;
    }
}
