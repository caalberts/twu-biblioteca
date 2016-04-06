package com.twu.biblioteca;

/**
 * Created by albert on 6/4/16.
 */
public class InputHandler {
  private Helper helper = new Helper();
  private Library lib;
  private String output = "";

  public String process (String input, Library library) {
    lib = library;
    switch (input) {
      case "List Books":
        handleListBooks();
        break;
      case "Checkout":
        handleCheckout();
        break;
      case "Return":
        handleReturn();
        break;
      case "Quit":
        output = "";
        break;
      default:
        output = "Select a valid option!";
    }
    return output;
  }

  private void handleListBooks() {
    output = "Books available for loan:\n";
    for (Book book : lib.listAvailableBooks()) {
      String bookDetails = book.getTitle() + " by " +
          book.getAuthor() +
          " (" + book.getYear() +")\n";
      output += bookDetails;
    }
    output += "\n";
  }

  private void handleCheckout() {
    String checkoutBookTitle = helper.getUserInput("Which book would you like to borrow?");

    if (lib.isAvailable(checkoutBookTitle)) {
      lib.checkout(checkoutBookTitle);
      output = "Thank you, enjoy the book.";
    } else {
      output = "That book is not available.";
    }
  }

  private void handleReturn() {
    String returnBookTitle = helper.getUserInput("Which book would you like to return?");

    if (lib.isLoaned(returnBookTitle)) {
      lib.returnBook(returnBookTitle);
      output = "Thank you for returning the book.";
    } else {
      output = "That is not a valid book to return.";
    }
  }

  public String getOutput() {
    return output;
  }
}
