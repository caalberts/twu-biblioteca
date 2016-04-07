package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by albert on 6/4/16.
 */
public class InputHandler {
  private Helper helper;
  private Library<Book> bookLib;
  private Library<Movie> movieLib;
  private User currentUser;
  private ArrayList<User> userList;
  private boolean loggedIn;

  InputHandler(Library<Book> bookLibrary, Library<Movie> movieLibrary, Helper help, boolean isLoggedIn, User person, ArrayList<User> allUsers) {
    bookLib = bookLibrary;
    movieLib = movieLibrary;
    helper = help;
    loggedIn = isLoggedIn;
    currentUser = person;
    userList = allUsers;
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
      case "Log In":
        String libNumber = helper.getUserInput("Enter your library number");
        String password = helper.getUserInput("Enter your password");
        output = handleLogIn(libNumber, password);
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
    if (lib.isBookAvailable(checkoutBookTitle)) {
      lib.checkoutBook(checkoutBookTitle);
      return "Thank you, enjoy the book.";
    } else {
      return "That book is not available.";
    }
  }

  public String handleCheckoutMovie(String checkoutMovieTitle) {
    if (movieLib.isItemAvailable(checkoutMovieTitle)) {
      movieLib.checkoutItem(checkoutMovieTitle);
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

  public String handleLogIn(String libraryNumber, String password) {
    for (User user : userList) {
      if (user.getLibraryNumber() == Integer.parseInt(libraryNumber, 10)) {
        if (user.getPassword().equals(password)) {
          currentUser = user;
          loggedIn = true;
          return "You're logged in";
        }
        else return "Wrong password";
      }
    }
    return "Library number is not found";
  }

  public String handleViewProfile() {
    String buffer = "Name: " + currentUser.getName() + "\n" +
                    "Email: " + currentUser.getEmail() + "\n" +
                    "Phone: " + currentUser.getPhone();
    return buffer;
  }
}
