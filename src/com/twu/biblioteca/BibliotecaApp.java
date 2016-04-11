package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
  private InputHandler handler;
  private Authenticator auth;
  private Library<Book> bookLibrary = new Library<>();
  private Library<Movie> movieLibrary = new Library<>();
  private ArrayList<User> userList = new ArrayList<>();

  private boolean isLoggedIn = false;
  private User user = null;

  public void start() {
    String userCommand = "";
    Helper.initializeLibrary(bookLibrary, movieLibrary);
    Helper.initializeUserList(userList);

    System.out.println("Welcome to Biblioteca.\n");

    while (!userCommand.equals("Quit")) {
      handler = new InputHandler(bookLibrary, movieLibrary, user);

      ArrayList<String> options = Helper.showOptions(isLoggedIn);
      String prompt = "How can I help you?\n" +
          "Type any of the following commands:\n";

      for (int i = 0; i < options.size(); i++) {
        prompt += Integer.toString(i + 1) + ". " +
                  "'" + options.get(i) + "'\n";
      }

      userCommand = Helper.getUserInput(prompt);

      if (userCommand.equals("Log In")) {
        logInUser();
      } else if (userCommand.equals("Log Out")) {
        logOutUser();
      } else {
        String output = handler.process(userCommand);
        System.out.println(output);
      }
    }
    return;
  }

  private void logInUser() {
    String libNumber = Helper.getUserInput("Enter your library number");
    String password = Helper.getUserInput("Enter your password");
    auth = new Authenticator(libNumber, password, userList);
    if (auth.findUser() != null) {
      if (auth.isSuccessfulLogin()) {
        user = auth.findUser();
        isLoggedIn = true;
        System.out.println("You're logged in");
      } else {
        System.out.println("Wrong password");
      }
    } else {
      System.out.println("Library number is not found");
    }
  }

  private void logOutUser() {
    isLoggedIn = false;
    user = null;
    System.out.println("You're logged out");
  }
}
