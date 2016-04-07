package com.twu.biblioteca;

/**
 * Created by albert on 6/4/16.
 */
public class InputHandler {
  private Helper helper;
  private Library lib;

  InputHandler(Library library, Helper help) {
    lib = library;
    helper = help;
  }

  public String process (String input) {
    String output;
    switch (input) {
      case "List Books":
        output = handleListBooks();
        break;
      case "Checkout":
        output = handleCheckout(helper.getUserInput("Which book would you like to borrow?"));
        break;
      case "Return":
        output = handleReturn(helper.getUserInput("Which book would you like to return?"));
        break;
      case "Quit":
        output = "";
        break;
      default:
        output = "Select a valid option!";
    }
    return output;
  }

  public String handleListBooks() {
    String buffer = "Books available for loan:\n";
    for (Book book : lib.listAvailableBooks()) {
      String bookDetails = book.getTitle() + " by " +
          book.getAuthor() +
          " (" + book.getYear() +")\n";
      buffer += bookDetails;
    }
    buffer += "\n";
    return buffer;
  }

  public String handleCheckout(String checkoutBookTitle) {
    if (lib.isAvailable(checkoutBookTitle)) {
      lib.checkout(checkoutBookTitle);
      return "Thank you, enjoy the book.";
    } else {
      return "That book is not available.";
    }
  }

  public String handleReturn(String returnBookTitle) {
    if (lib.isLoaned(returnBookTitle)) {
      lib.returnBook(returnBookTitle);
      return "Thank you for returning the book.";
    } else {
      return "That is not a valid book to return.";
    }
  }
}
