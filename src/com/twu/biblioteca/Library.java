package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private List<Book> books;
    private List<Movie> availableMovies;

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        this.availableMovies = movies;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public List<Book> getAvailableBooks() {
        return new ArrayList<>(books.stream().filter(b -> b.isAvailable()).collect(Collectors.toList()));
    }

    public List<Book> getUnavailableBooks() {
        return new ArrayList<>(books.stream().filter(b -> !b.isAvailable()).collect(Collectors.toList()));
    }

    public boolean canChangeStatus(String bookName, List<Book> list) {
        Book book = searchBookByName(bookName);
        if (book == null || list.contains(book)) {
            return false;
        }
        return true;
    }


    public void checkinBook(String bookName, User user) {
        Book book = searchBookByName(bookName);
        if (book.getCurrentHolder().equals(user)) {
            book.returnItem(user);
        } else {
            System.out.println("You're not the current holder of this book, try another one");
        }
    }

    public void checkoutBook(String name, User user) {
        Book book = searchBookByName(name);
        book.checkoutItem(user);

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
        return books;
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public void checkoutMovie(String movieName) {
        Movie movie = searchMovieByName(movieName);
        availableMovies.remove(movie);
    }

    private Movie searchMovieByName(String movieName) {
        Movie movie = null;
        for (Movie m : getAvailableMovies()) {
            if (m.getName().equals(movieName)) {
                movie = m;
                break;
            }
        }
        return movie;
    }

//    public LibraryItem searchItemBy(String itemName, List<LibraryItem> list) {
//        LibraryItem item = null;
//        for (LibraryItem li : list) {
//            if (li.equals())
//        }
//    }
}
