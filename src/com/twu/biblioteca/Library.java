package com.twu.biblioteca;

import sun.rmi.rmic.iiop.Type;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private List<LibraryItem> items;

    public Library(List<LibraryItem> items) {
        this.items = items;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public LibraryItem searchItemByName(String itemName, ItemType itemType) {
        for (LibraryItem m : getAllItens() ) {
            if (m.getName().equals(itemName) && m.getType() == itemType) {
                return m;
            }
        }
        return null;
    }

    public String checkinItem(LibraryItem book, User user) {
        if (book.getCurrentHolder().equals(user)) {
            book.returnItem(user);
            return "Thanks for returning your item";
        } else {
            return "You can`t return this item, try another one";
        }
    }

    public String checkoutItem(LibraryItem item, User user) {
        if (item != null && item.isAvailable()) {
            item.checkoutItem(user);
            return "Enjoy your item";
        } else {
            return "Item not found";
        }
    }
    

    public List<LibraryItem> getAllItens() {
        return new ArrayList<>(items);
    }
    public List<LibraryItem> getAvailableMovies() {
        return new ArrayList<>(items.stream().filter(li -> li.isAvailable() && li.getType() == ItemType.MOVIE).collect(Collectors.toList()));
    }

    public List<LibraryItem> getAvailableBooks() {
        return new ArrayList<>(items.stream().filter(LI -> LI.isAvailable() && LI.getType() == ItemType.BOOK).collect(Collectors.toList()));
    }

    public List<LibraryItem> getUnavailableBooks() {
        return new ArrayList<>(items.stream().filter(b -> !b.isAvailable() && b.getType() == ItemType.BOOK).collect(Collectors.toList()));
    }

}
