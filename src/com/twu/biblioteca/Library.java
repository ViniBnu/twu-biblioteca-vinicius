package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vsolive on 28/03/17.
 */
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

    public boolean canCheckout(String bookName) {
        Book book = this.searchBookByName(bookName, availableBooks);
        if( book == null || (unavailableBooks.contains(book))) {
            return false;
        }
        return true;
    }

    public Book searchBookByName(String bookName, List<Book> bookList) {
        Book book = null;
        for(Book b : bookList) {
            if (b.getName().toLowerCase().equals(bookName.toLowerCase())) {
                book = b;
                break;
            }
        }
        return book;
    }

    public void checkoutBook(String name) {
        Book book = searchBookByName(name, availableBooks);
        availableBooks.remove(book);
        unavailableBooks.add(book);
    }


    public boolean canCheckin(String bookName) {
        Book book = this.searchBookByName(bookName, unavailableBooks);
        if( book == null || (availableBooks.contains(book))) {
            return false;
        }
        return true;
    }


    public void checkinBook(String bookName) {
        Book book = searchBookByName(bookName, unavailableBooks);
        unavailableBooks.remove(book);
        availableBooks.add(book);
    }
}
