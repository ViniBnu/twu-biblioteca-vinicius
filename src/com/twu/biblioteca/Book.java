package com.twu.biblioteca;



/**
 * Created by vsolive on 28/03/17.
 */
public class Book {
    private String name;
    private String author;
    private Integer releaseYear;
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

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getReleaseYear() {
        return releaseYear;
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

    public User getCurrentHolder() {
        return currentHolder;
    }

    public void returnBook() {
        this.currentHolder = null;
    }
    public void checkoutBook(User user) {
        this.currentHolder = user;
    }


}
