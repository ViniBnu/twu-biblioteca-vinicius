package com.twu.biblioteca;

/**
 * Created by vsolive on 04/04/17.
 */
public interface LibraryItem {

    void checkoutItem(User user);
    void returnItem(User user);
    boolean isAvailable();


}
