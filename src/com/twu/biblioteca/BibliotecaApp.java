package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
  private String userCommand = "";

  Helper helper = new Helper();
  Library library = new Library();

  public void start() {
    System.out.println("Welcome to Biblioteca.\n");

    userCommand = askUserForCommand();

    while (!userCommand.equals("Quit")) {
      switch (userCommand) {
        case "List Books":
          ListBooks.display(library.listAvailableBooks());
          break;
        case "Checkout": {
          String bookTitle = helper.getUserInput("Which book would you like to borrow?");
          System.out.println(bookTitle);
          boolean successfulCheckout = library.checkout(bookTitle);
          if (successfulCheckout) {
            System.out.println("Thank you, enjoy the book.");
          } else {
            System.out.println("That book is not available.");
            ListBooks.display(library.listAvailableBooks());
          }
        }
        case "Quit":
          break;
        default:
          System.out.println("Select a valid option!");
      }
      userCommand = askUserForCommand();
    }
    return;
  }

  public String askUserForCommand() {
    String prompt = "How can I help you?\n" +
                    "Type any of the following commands:\n" +
                    "1. 'List Books'\n" +
                    "2. 'Checkout'\n" +
                    "3. 'Return'\n" +
                    "4. 'Quit'\n";
    return helper.getUserInput(prompt);
  }
}
