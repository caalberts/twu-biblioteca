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
      userCommand = helper.getUserInput("How can I help you?\nType 'Quit' to leave Biblioteca.");
    }
    return;
  }

  public void displayBooks(ArrayList<Book> books) {
    for (Book book : books) {
      String bookDetails = book.getTitle() + " by " +
               book.getAuthor() +
               " (" + book.getYear() +")";
      System.out.println(bookDetails);
    }
    System.out.println("\n");
  }
}
