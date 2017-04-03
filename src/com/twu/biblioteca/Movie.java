package com.twu.biblioteca;

/**
 * Created by vsolive on 03/04/17.
 */
public class Movie {
    private String name;
    private String director;
    private Integer year;
    private Integer rating;

    public Movie(String name, String director, Integer year, Integer rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}
