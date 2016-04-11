package com.twu.biblioteca;

/**
 * Created by albert on 6/4/16.
 */
public class InputHandler {
  private Library<Book> bookLib;
  private Library<Movie> movieLib;
  private User currentUser;

  InputHandler(Library<Book> bookLibrary, Library<Movie> movieLibrary, User person) {
    bookLib = bookLibrary;
    movieLib = movieLibrary;
    currentUser = person;
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
        output = (currentUser != null) ? (Helper.getUserInput("Which book would you like to borrow?")) : "Please log in before checking out a book.";
        break;
      case "Checkout Movie":
        output = (currentUser != null) ? handleCheckoutMovie(Helper.getUserInput("Which movie would you like to borrow?")) : "Please log in before checking out a movie.";
        break;
      case "Return Book":
        output = (currentUser != null) ? handleReturnBook(Helper.getUserInput("Which book would you like to return?")) : "Please log in before returning a book.";
        break;
      case "Return Movie":
        output = (currentUser != null) ? handleReturnMovie(Helper.getUserInput("Which movie would you like to return?")) : "Please log in before returning a movie.";
        break;
      case "View Profile":
        output = (currentUser != null) ? handleViewProfile() : "Please log in before viewing profile.";
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
    for (Book book : bookLib.getAvailableItems()) {
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
    for (Movie movie : movieLib.getAvailableItems()) {
      String movieDetails = movie.getTitle() + " directed by " +
          movie.getDirector() +
          " (" + movie.getYear() + ")\n";
      buffer += movieDetails;
    }
    buffer += "\n";
    return buffer;
  }

  public String handleCheckoutBook(String checkoutBookTitle) {
    if (bookLib.isItemAvailable(checkoutBookTitle)) {
      bookLib.checkoutItem(checkoutBookTitle, currentUser.getLibraryNumber());
      return "Thank you, enjoy the book.";
    } else {
      return "That book is not available.";
    }
  }

  public String handleCheckoutMovie(String checkoutMovieTitle) {
    if (movieLib.isItemAvailable(checkoutMovieTitle)) {
      movieLib.checkoutItem(checkoutMovieTitle, currentUser.getLibraryNumber());
      return "Thank you, enjoy the movie.";
    } else {
      return "That movie is not available.";
    }
  }

  public String handleReturnBook(String returnBookTitle) {
    if (bookLib.isItemLoaned(returnBookTitle)) {
      bookLib.returnItem(returnBookTitle);
      return "Thank you for returning the book.";
    } else {
      return "That is not a valid book to return.";
    }
  }

  public String handleReturnMovie(String returnMovieTitle) {
    if (movieLib.isItemLoaned(returnMovieTitle)) {
      movieLib.returnItem(returnMovieTitle);
      return "Thank you for returning the movie.";
    } else {
      return "That is not a valid movie to return.";
    }
  }

  public String handleViewProfile() {
    String buffer = "Name: " + currentUser.getName() + "\n" +
                    "Email: " + currentUser.getEmail() + "\n" +
                    "Phone: " + currentUser.getPhone();
    return buffer;
  }
}
