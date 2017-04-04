package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

/**
 * Created by vsolive on 30/03/17.
 */
public class LibrarySystem {

    private Library library;
    private Scanner scanner;
    private List<User> userList;
    private User currentUser;

    public LibrarySystem(Library library, List<User> users) {
        this.library = library;
        scanner = new Scanner(System.in);
        this.userList = users;
    }

    public void run() {
        System.out.println("Welcome to Biblioteca!");
        do {
            performLogin();
        } while(!performLogin());
        String choice;
        do {
            choice = promptMenuAction();

            switch (choice) {
                case "list books":
                    showAvailableBookDetails();
                    break;
                case "quit":
                    System.out.println("Thanks for acessing Biblioteca, come again");
                    break;
                case "check out book":
                    promptForBookCheckout();
                    break;
                case "check in book":
                    promptForBookCheckin();
                    break;
                case "check out movie":
                    promptForMovieCheckout();
                    break;
                case "user info":
                    System.out.println(currentUser);
                    break;
                default:
                    System.out.println("Couldn't understand that, help me help you");
            }

        } while (!choice.equals("quit"));

    }

    private boolean performLogin() {
        System.out.println("Enter your library number");
        String numer = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();

        for(User user : userList) {
            if (user.getLibraryNumber().equals(numer.toLowerCase()) && user.getPassword().equals(password.toLowerCase())) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    private void promptForMovieCheckout() {
        System.out.println("This is the list of available Movies, choose one of them to take home");
        showAvailableMovieDetails();
        String movieName;
        movieName = scanner.nextLine();
        if(library.getAvailableMovies().contains(new Movie(movieName,null,null,null))) {
            library.checkoutMovie(movieName);
            System.out.println("Enjoy your movie");
        } else {
            System.out.println("Movie not found or not available");
        }
    }

    private void showAvailableMovieDetails() {
        library.getAvailableMovies().forEach(System.out::println);
    }

    private void promptForBookCheckin() {
        System.out.println("This is the list of books not available, which one would you like to return?");
        showUnavailableBookDetails();
        String bookName;
        bookName = scanner.nextLine();
        if (library.canChangeStatus(bookName, library.getAvailableBooks())) {
            library.checkinBook(bookName);
            System.out.println("Thank you for returning the book");
        } else {
            System.out.println("That book is not due");
        }
    }

    private void promptForBookCheckout() {
        System.out.println("This is the list of books available, type in the name of the book you wish to checkout");
        showAvailableBookDetails();
        String bookName;
        bookName = scanner.nextLine();
        if (library.canChangeStatus(bookName, library.getUnavailableBooks())) {
            library.checkoutBook(bookName);
            System.out.println("Thank you, hope you enjoy your book");
        } else {
            System.out.println("That book is unavailable");
        }
    }

    private String promptMenuAction() {
        System.out.println("Choose one of the options bellow:");
        System.out.println("List Books");
        System.out.println("Checkout Book");
        System.out.println("Check in Book");
        System.out.println("Check out Movie");
        System.out.println("User information");
        System.out.println("Quit");
        return scanner.nextLine().toLowerCase().trim();
    }

    public void showAvailableBookDetails() {
        library.getAvailableBooks().forEach(System.out::println);
    }

    private void showUnavailableBookDetails() {
        library.getUnavailableBooks().forEach(System.out::println);
    }
}
