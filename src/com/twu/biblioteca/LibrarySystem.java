package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

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
        boolean loggedIn = false;
        do {
           loggedIn =  performLogin();
        } while(!loggedIn);

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
                    System.out.println("This is the list of books available, type in the name of the book you wish to checkout");
                    showAvailableBookDetails();
                    promptForItemCheckout(ItemType.BOOK);
                    break;
                case "check in book":
                    System.out.println("This is the list of books not available, which one would you like to return?");
                    showUnavailableBookDetails();
                    promptForItemCheckin(ItemType.BOOK);
                    break;
                case "check out movie":
                    System.out.println("This is the list of available Movies, choose one of them to take home");
                    showAvailableMovieDetails();
                    promptForItemCheckout(ItemType.MOVIE);
                    break;
                case "user information":
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
            if (user.getLibraryNumber().equals(numer) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    private void promptForItemCheckin(ItemType itemType) {
        LibraryItem book = library.searchItemByName(scanner.nextLine(), itemType);
        String successOrFailureMessage = library.checkinItem(book, currentUser);
        System.out.println(successOrFailureMessage);
    }

    private void promptForItemCheckout(ItemType itemType) {
        LibraryItem book = library.searchItemByName(scanner.nextLine(), itemType);
        String successOrFailureMessage = library.checkoutItem(book, currentUser);
        System.out.println(successOrFailureMessage);
    }

    private String promptMenuAction() {
        System.out.println("Choose one of the options bellow:");
        System.out.println("List Books");
        System.out.println("Check out Book");
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

    private void showAvailableMovieDetails() {
        library.getAvailableMovies().forEach(System.out::println);
    }
}
