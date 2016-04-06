package com.twu.biblioteca;

/**
 * Created by albert on 6/4/16.
 */
public class InputHandler {
  private Helper helper = new Helper();
  private Library lib;
  private String output = "";

  InputHandler(Library library) {
    lib = library;
  }

  public String process (String input) {
    switch (input) {
      case "List Books":
        handleListBooks();
        break;
      case "Checkout":
        handleCheckout(helper.getUserInput("Which book would you like to borrow?"));
        break;
      case "Return":
        handleReturn(helper.getUserInput("Which book would you like to return?"));
        break;
      case "Quit":
        output = "";
        break;
      default:
        output = "Select a valid option!";
    }
    return output;
  }

  public void handleListBooks() {
    output = "Books available for loan:\n";
    for (Book book : lib.listAvailableBooks()) {
      String bookDetails = book.getTitle() + " by " +
          book.getAuthor() +
          " (" + book.getYear() +")\n";
      output += bookDetails;
    }
    output += "\n";
  }

  public void handleCheckout(String checkoutBookTitle) {
    if (lib.isAvailable(checkoutBookTitle)) {
      lib.checkout(checkoutBookTitle);
      output = "Thank you, enjoy the book.";
    } else {
      output = "That book is not available.";
    }
  }

  public void handleReturn(String returnBookTitle) {
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
