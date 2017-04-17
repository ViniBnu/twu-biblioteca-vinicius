package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private List<LibraryItem> books;
    private List<LibraryItem> movies;

    public Library(List<LibraryItem> books, List<LibraryItem> movies) {
        this.books = books;
        this.movies = movies;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public LibraryItem searchItemByName(String itemName) {
        for (LibraryItem m : getAllItens() ) {
            if (m.getName().equals(itemName)) {
                return m;
            }
        }
        return null;
    }

    public String checkinItem(LibraryItem book, User user) {
        if (book.getCurrentHolder().equals(user)) {
            book.returnItem(user);
            return "Thanks for returning your item";
        } else {
            return "You can`t return this book, try another one";
        }
    }

    public String checkoutItem(LibraryItem item, User user) {
        if (item != null && item.isAvailable()) {
            item.checkoutItem(user);
            return "Enjoy your book";
        } else {
            return "Book not found";
        }
    }

    public List<LibraryItem> getAllItens() {
        List<LibraryItem> list = new ArrayList<>();
        list.addAll(books);
        list.addAll(movies);
        return list;
    }

    public List<LibraryItem> getMovies() {
        return movies;
    }
    public List<LibraryItem> getAvailableMovies() {
        return new ArrayList<LibraryItem>(movies.stream().filter(LibraryItem::isAvailable).collect(Collectors.toList()));
    }

    public List<LibraryItem> getAvailableBooks() {
        return new ArrayList<>(books.stream().filter(LibraryItem::isAvailable &&).collect(Collectors.toList()));
    }

    public List<LibraryItem> getUnavailableBooks() {
        return new ArrayList<>(books.stream().filter(b -> !b.isAvailable()).collect(Collectors.toList()));
    }

}
