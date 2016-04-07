package com.twu.biblioteca;

/**
 * Created by albert on 6/4/16.
 */
public class InputHandler {
  private Helper helper;
  private Library lib;
  private User user;

  InputHandler(Library library, Helper help, User person) {
    lib = library;
    helper = help;
    user = person;
  }

  public String process (String input) {
    String output;
    switch (input) {
      case "List Books":
        output = handleListBooks();
        break;
      case "List Movies":
        output = handleListMovies();
        break;
      case "Checkout Book":
        output = handleCheckoutBook(helper.getUserInput("Which book would you like to borrow?"));
        break;
      case "Checkout Movie":
        output = handleCheckoutMovie(helper.getUserInput("Which movie would you like to borrow?"));
        break;
      case "Return Book":
        output = handleReturnBook(helper.getUserInput("Which book would you like to return?"));
        break;
      case "Return Movie":
        output = handleReturnMovie(helper.getUserInput("Which movie would you like to return?"));
        break;
      case "View Profile":
        output = handleViewProfile();
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
    for (Book book : lib.getAvailableBooks()) {
      String bookDetails = book.getTitle() + " written by " +
          book.getAuthor() +
          " (" + book.getYear() +")\n";
      buffer += bookDetails;
    }
    buffer += "\n";
    return buffer;
  }

  public String handleListMovies() {
    String buffer = "Movies available for loan:\n";
    for (Movie movie : lib.getAvailableMovies()) {
      String movieDetails = movie.getTitle() + " directed by " +
          movie.getDirector() +
          " (" + movie.getYear() + ")\n";
      buffer += movieDetails;
    }
    buffer += "\n";
    return buffer;
  }

  public String handleCheckoutBook(String checkoutBookTitle) {
    if (lib.isBookAvailable(checkoutBookTitle)) {
      lib.checkoutBook(checkoutBookTitle);
      return "Thank you, enjoy the book.";
    } else {
      return "That book is not available.";
    }
  }

  public String handleCheckoutMovie(String checkoutMovieTitle) {
    if (lib.isMovieAvailable(checkoutMovieTitle)) {
      lib.checkoutMovie(checkoutMovieTitle);
      return "Thank you, enjoy the movie.";
    } else {
      return "That movie is not available.";
    }
  }

  public String handleReturnBook(String returnBookTitle) {
    if (lib.isBookLoaned(returnBookTitle)) {
      lib.returnBook(returnBookTitle);
      return "Thank you for returning the book.";
    } else {
      return "That is not a valid book to return.";
    }
  }

  public String handleReturnMovie(String returnMovieTitle) {
    if (lib.isMovieLoaned(returnMovieTitle)) {
      lib.returnMovie(returnMovieTitle);
      return "Thank you for returning the movie.";
    } else {
      return "That is not a valid movie to return.";
    }
  }

  public String handleViewProfile() {
    String buffer = "Name: " + user.getName() + "\n" +
                    "Email: " + user.getEmail() + "\n" +
                    "Phone: " + user.getPhone();
    return buffer;
  }
}
