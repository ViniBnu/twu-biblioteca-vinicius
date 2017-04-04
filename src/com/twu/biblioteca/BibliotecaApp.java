package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        List<Book> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("1984", "Orwell", 1949));
        availableBooks.add( new Book("Hobbit", "Tolkien", 1949));
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Rocky", "Avildsen", 1979, 10));

        Library library = new Library(availableBooks, new ArrayList<>(), movies);
        List<User> users = new ArrayList<>();
        users.add(new User("vini", "vini.bnu@gmail.com", "99581533", "444-4444", "1234"));
        LibrarySystem system = new LibrarySystem(library, users);




        system.run();








    }
}
