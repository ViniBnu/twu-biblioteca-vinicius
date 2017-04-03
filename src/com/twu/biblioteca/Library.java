package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private List<Book> availableBooks;
    private List<Book> unavailableBooks;
    private List<Movie> availableMovies;

    public Library(List<Book> availableBooks, List<Book> unavailableBooks, List<Movie> movies) {
        this.availableBooks = availableBooks;
        this.unavailableBooks = unavailableBooks;
        this.availableMovies = movies;
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
}
