package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vsolive on 28/03/17.
 */
public class LibraryTest {

    Library library;
    LibrarySystem system;

    @Before
    public void setUp() throws Exception {
        List<Book> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("1984", "Orwell", 1949));
        availableBooks.add( new Book("Hobbit", "Tolkien", 1949));
        library = new Library(availableBooks, new ArrayList<>());

    }

    @Test
    public void checkoutBook_shouldTakeBookOffAvailableBooks() throws Exception {
        library.checkoutBook("1984");

        assertEquals(1, library.getAvailableBooks().size());
    }

    @Test
    public void checkinBook_shouldPutReturnedBookBackToAvailableList() throws Exception {
        library.checkoutBook("1984");
        library.checkinBook("1984");

        assertEquals(0, library.getUnavailableBooks().size());
    }

    @Test
    public void searchBookByName_shouldReturnRightBook() throws Exception {
        Book book = library.searchBookByName("1984");

        assertEquals(book, library.getAvailableBooks().get(0));
    }

    @Test
    public void searchBookByName_returnsBookEvenIfUnavailable() throws Exception {
        library.checkoutBook("1984");
        Book book = library.searchBookByName("1984");

        assertEquals(book,library.getUnavailableBooks().get(0));
    }

    @Test
    public void canChangeStatus_shouldReturnTrueWhenAskedBookIsAvailable() throws Exception {
        assertEquals(true, library.canChangeStatus("1984", library.getUnavailableBooks()));
    }

    @Test
    public void canChangeStatus_shouldReturnFalseWhenTryingToCheckoutBookAlreadyOut() throws Exception {
        library.checkoutBook("1984");

        assertEquals(false, library.canChangeStatus("1984", library.getUnavailableBooks()));
    }


}