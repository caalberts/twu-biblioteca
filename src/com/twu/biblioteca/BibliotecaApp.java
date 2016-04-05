package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
  private String userCommand = "";

  Helper helper = new Helper();
  Library library = new Library();

  public void start() {
    System.out.println("Welcome to Biblioteca.");
    System.out.println("Here are all the books in Biblioteca:\n");

    displayBooks(library.listBooks());
    while (!userCommand.equals("Quit")) {
      if (userCommand.equals("List Books")) {
        displayBooks(library.listAvailableBooks());
      } else {
        System.out.println("Select a valid option!");
      }
      userCommand = askUserForCommand();
    }
    return;
  }

  public void displayBooks(ArrayList<Book> books) {
    System.out.println("Books available for loan");
    for (Book book : books) {
      String bookDetails = book.getTitle() + " by " +
               book.getAuthor() +
               " (" + book.getYear() +")";
      System.out.println(bookDetails);
    }
    System.out.println("\n");
  }

  public String askUserForCommand() {
    String prompt = "How can I help you?\n" +
                    "Type any of the following commands:\n" +
                    "1. 'List Books'\n" +
                    "2. 'Quit'\n";
    return helper.getUserInput(prompt);
  }
}
