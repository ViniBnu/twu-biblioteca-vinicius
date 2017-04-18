package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();
        items.add(new LibraryItem("1984", "Orwell", 1949, ItemType.BOOK));
        items.add( new LibraryItem("Hobbit", "Tolkien", 1949, ItemType.BOOK));
        items.add(new LibraryItem("Rocky", "Avildsen", 1979, 10, ItemType.MOVIE));

        Library library = new Library(items);
        List<User> users = new ArrayList<>();
        users.add(new User("vini", "vini.bnu@gmail.com", "99581533", "444-4444", "1234"));
        LibrarySystem system = new LibrarySystem(library, users);

        system.run();

    }
}
