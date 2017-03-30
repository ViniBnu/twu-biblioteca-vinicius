package com.twu.biblioteca;



/**
 * Created by vsolive on 28/03/17.
 */
public class Book {
    private String name;
    private String author;
    private Integer releaseYear;
    private boolean available;

    public Book(String name, String author, Integer releaseYear) {
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        this.available = true;

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

    public boolean isAvailable(){
        return available;
    }

}
