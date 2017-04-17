package com.twu.biblioteca;

public class Movie implements LibraryItem {
    private String name;
    private String director;
    private Integer year;
    private Integer rating;
    private User currentHolder;

    public Movie(String name, String director, Integer year, Integer rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.currentHolder = null;
    }

    @Override
    public String toString() {
        return "Movie name - '" + name + '\'' +
                "- director '" + director + '\'' +
                "- year " + year +
                ", rating " + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return name != null ? name.equals(movie.name) : movie.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
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

    @Override
    public User getCurrentHolder() {
        return this.currentHolder;
    }

    @Override
    public String getName() {
        return name;
    }
}
