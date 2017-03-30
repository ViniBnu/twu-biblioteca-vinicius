package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        Library library = new Library(new ArrayList<>(Arrays.asList(new Book("1984", "Orwell", 1949),
                                                                    new Book("Hobbit", "Tolkien", 1949))));
        LibrarySystem system = new LibrarySystem(library);
        system.run();









    }
}
