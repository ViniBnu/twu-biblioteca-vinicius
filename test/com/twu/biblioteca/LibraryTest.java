package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by vsolive on 28/03/17.
 */
public class LibraryTest {

    Library library;
    LibrarySystem system;

    @Before
    public void setUp() throws Exception {
        library = new Library(Arrays.asList(new Book("1984", "Orwell", 1949),
                new Book("Hobbit", "Tolkien", 1949)));

    }

    @Test
    public void shouldReturnWelcomeMessage() throws Exception {
        assertEquals("Welcome to Biblioteca!", library.getWelcomeMessage());
    }
}