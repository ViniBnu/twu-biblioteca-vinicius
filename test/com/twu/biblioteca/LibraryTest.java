package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vsolive on 28/03/17.
 */
public class LibraryTest {
    @Before

    @Test
    public void shouldReturnWelcomeMessage() throws Exception {

        Book book = new Book("1984", "Georger Orwell", 1949);
        List<Book> books = new ArrayList<>();
        books.add(book);
        Library library = new Library(books);

        assertEquals("Welcome to Biblioteca!", library.getWelcomeMessage());
    }

    @Test
    public void shouldReturnListOfAvailableBooks() throws Exception {
        


    }
}