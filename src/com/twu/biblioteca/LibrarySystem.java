package com.twu.biblioteca;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by vsolive on 30/03/17.
 */
public class LibrarySystem {

    private Library library;
    private Scanner scanner;

    public LibrarySystem(Library library) {
        this.library = library;
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to Biblioteca!");
        String choice = "";
        do {
            choice = promptMenuAction();

            switch (choice) {
                case "list books":
                    library.showAllBooksAvailable();
                    break;
                case "quit":
                    System.out.println("Thanks for acessing Biblioteca, come again");
                    break;
                default:
                    System.out.println("Couldn't understand that, help me help you");
            }

        } while (!choice.equals("quit"));


    }

    private String promptForBookCheckout() {
        System.out.println("This is the list of books available, type in the name of the book you wish to checkout");
        showBookDetails();
        String bookName = "";
        bookName = scanner.nextLine();
        return bookName;
    }

    private String promptMenuAction() {
        System.out.println("Choose one of the options bellow:");
        System.out.println("List Books");
        System.out.println("Quit");
        return scanner.nextLine().toLowerCase().trim();
    }

    public void showBookDetails() {
        library.getAvailableBooks().forEach(x -> System.out.println(x));
    }


}
