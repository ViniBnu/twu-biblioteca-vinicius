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

    @Override
    public String toString() {
        return "Movie name - '" + name + '\'' +
                "- director '" + director + '\'' +
                "- year " + year +
                ", rating " + rating;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return getName() != null ? getName().equals(movie.getName()) : movie.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
