package com.twu.biblioteca;



/**
 * Created by vsolive on 28/03/17.
 */
public class Book implements LibraryItem{
    private final String name;
    private final String author;
    private final Integer releaseYear;
    private User currentHolder;

    public Book(String name, String author, Integer releaseYear) {
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        currentHolder = null;

    }

    @Override
    public String toString() {
        return
                "book name '" + name + '\'' +
                " - author '" + author + '\'' +
                " - release Year " + releaseYear
                ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public User getCurrentHolder() {
        return currentHolder;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void checkoutItem(User user) {
        if (isAvailable()) {
            this.currentHolder = user;
        }
    }

    @Override
    public void returnItem(User user) {
        if (currentHolder.equals(user)) {
            this.currentHolder = null;
        } else {
            System.out.println("You're not the current holder");
        }
    }

    @Override
    public boolean isAvailable() {
        return currentHolder == null;
    }
}
