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

        Library library = new Library(availableBooks, new ArrayList<>());
        LibrarySystem system = new LibrarySystem(library);


        system.run();








    }
}
