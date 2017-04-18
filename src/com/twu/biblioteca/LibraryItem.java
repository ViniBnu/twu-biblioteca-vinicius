package com.twu.biblioteca;

/**
 * Created by vsolive on 04/04/17.
 */
public class LibraryItem {

    private final String name;
    private final String author;
    private final Integer releaseYear;
    private User currentHolder;
    private Integer rating = null;
    private ItemType type;

    public LibraryItem(String name, String author, Integer releaseYear, ItemType type) {
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        this.currentHolder = null;
        this.type = type;
    }

    public LibraryItem(String name, String author, Integer releaseYear, Integer rating,  ItemType type) {
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        this.currentHolder = null;
        this.rating = rating;
        this.type = type;
    }

    void checkoutItem(User user) {
        if(isAvailable()) {
            this.currentHolder = user;
        }
    }

    void returnItem(User user) {
        if(currentHolder.equals(user)) {
            this.currentHolder = null;
        } else {
            System.out.println("You're not the current holder, choose another book");
        }
    }

    boolean isAvailable() {
        return currentHolder == null;
    }

    User getCurrentHolder() {
        return currentHolder;
    }

    String getName() {
        return name;
    }

    ItemType getType() {
        return this.type;
    }

    @Override
    public String toString() {

        if (type == ItemType.BOOK) {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", releaseYear=" + releaseYear +
                    '}';
        }
        return "Movie{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryItem that = (LibraryItem) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getType() == that.getType();
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
