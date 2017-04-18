package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vsolive on 28/03/17.
 */
public class LibraryTest {

    Library library;
    LibrarySystem system;
    User user;

    @Before
    public void setUp() throws Exception {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new LibraryItem("1984", "Orwell", 1949, ItemType.BOOK));
        items.add( new LibraryItem("Hobbit", "Tolkien", 1949, ItemType.BOOK));
        items.add(new LibraryItem("Rocky", "Avildsen", 1979, 10, ItemType.MOVIE));
        user = new User("vini","vini.bnu@gmail.com","99581533","444-4444","1234");

        library = new Library(items);

    }

    @Test
    public void checkoutBook_shouldTakeBookOffAvailableBooks() throws Exception {
        library.checkoutItem(library.searchItemByName("1984", ItemType.BOOK), user);

        assertEquals(1, library.getAvailableBooks().size());
    }

    @Test
    public void checkinBook_shouldPutReturnedBookBackToAvailableList() throws Exception {
        library.checkoutItem(library.searchItemByName("1984", ItemType.BOOK),user);
        library.checkinItem(library.searchItemByName("1984", ItemType.BOOK),user);

        assertEquals(0, library.getUnavailableBooks().size());
    }

    @Test
    public void searchBookByName_shouldReturnRightBook() throws Exception {
        LibraryItem book = library.searchItemByName("1984", ItemType.BOOK);

        assertEquals(book, library.getAvailableBooks().get(0));
    }

    @Test
    public void searchBookByName_returnsBookEvenIfUnavailable() throws Exception {
        library.checkoutItem(library.searchItemByName("1984", ItemType.BOOK),user);
        LibraryItem book = library.searchItemByName("1984", ItemType.BOOK);

        assertEquals(book,library.getUnavailableBooks().get(0));
    }

    @Test
    public void getAvailableMovies_shouldReturnListOfAvailableMovies() throws Exception {
        assertEquals(1, library.getAvailableMovies().size());
    }

    @Test
    public void checkoutMovie_shouldTakeMovieOutOfAvailableList() throws Exception {
        library.checkoutItem(library.searchItemByName("Rocky", ItemType.MOVIE), user);

        assertEquals(0, library.getAvailableMovies().size());
    }

    @Test
    public void checkoutBook_shouldSetUserAsCurrentHolder() throws Exception {
        library.checkoutItem(library.searchItemByName("1984", ItemType.BOOK), user);

        assertEquals(user, library.searchItemByName("1984", ItemType.BOOK).getCurrentHolder());
    }

    @Test
    public void checkinBook_shouldChangeBookHolderToNull() throws Exception {
        library.checkoutItem(library.searchItemByName("1984", ItemType.BOOK), user);
        library.checkinItem(library.searchItemByName("1984", ItemType.BOOK), user);

        assertEquals(null, library.searchItemByName("1984", ItemType.BOOK).getCurrentHolder());
    }

    @Test
    public void checkinBook_shouldOnlyWorkIfCurrentUserIsTheSameReturningBook() throws Exception {
        library.checkoutItem(library.searchItemByName("1984", ItemType.BOOK), user);
        library.checkinItem(library.searchItemByName("1984", ItemType.BOOK), new User(null, null, null, null, null));

        assertEquals(user, library.searchItemByName("1984", ItemType.BOOK).getCurrentHolder());
    }
}