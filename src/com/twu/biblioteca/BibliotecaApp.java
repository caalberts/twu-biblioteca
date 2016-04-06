package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
  private String userCommand = "";

  private Helper helper = new Helper();
  private Library library = new Library();

  public void start() {
    initializeLibrary();

    System.out.println("Welcome to Biblioteca.\n");

    userCommand = askUserForCommand();

    while (!userCommand.equals("Quit")) {
      switch (userCommand) {
        case "List Books":
          ListBooks.display(library.listAvailableBooks());
          break;
        case "Checkout":
          String checkoutBookTitle = helper.getUserInput("Which book would you like to borrow?");

          boolean successfulCheckout = library.checkout(checkoutBookTitle);
          if (successfulCheckout) {
            System.out.println("Thank you, enjoy the book.");
          } else {
            System.out.println("That book is not available.");
            ListBooks.display(library.listAvailableBooks());
          }
          break;
        case "Return":
          String returnBookTitle = helper.getUserInput("Which book would you like to return?");
          boolean successfulReturn = library.returnBook(returnBookTitle);
          if (successfulReturn) {
            System.out.println("Thank you for returning the book.");
          } else {
            System.out.println("That is not a valid book to return.");
          }
          break;
        case "Quit":
          break;
        default:
          System.out.println("Select a valid option!");
      }
      userCommand = askUserForCommand();
    }
    return;
  }

  private String askUserForCommand() {
    String prompt = "How can I help you?\n" +
                    "Type any of the following commands:\n" +
                    "1. 'List Books'\n" +
                    "2. 'Checkout'\n" +
                    "3. 'Return'\n" +
                    "4. 'Quit'\n";
    return helper.getUserInput(prompt);
  }

  private void initializeLibrary() {
    library.addNewBook(new Book("Head First Java", "Kathy Sierra", 2005));
    library.addNewBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    library.addNewBook(new Book("Test Driven Development", "Kent Beck", 2002));
    library.addNewBook(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    library.addNewBook(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    library.addNewBook(new Book("The 5 Love Languages", "Gary Chapman", 1995));
  }
}
