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
    initializeLibrary();
    initializeUserList();

    System.out.println("Welcome to Biblioteca.\n");

    while (!userCommand.equals("Quit")) {
      handler = new InputHandler(bookLibrary, movieLibrary, user);

      ArrayList<String> options = showOptions(isLoggedIn);
      String prompt = "How can I help you?\n" +
          "Type any of the following commands:\n";

      for (int i = 0; i < options.size(); i++) {
        prompt += Integer.toString(i + 1) + ". " +
                  "'" + options.get(i) + "'\n";
      }

      userCommand = Helper.getUserInput(prompt);

      if (userCommand.equals("Log In")) {
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
      } else {
        String output = handler.process(userCommand);
        System.out.println(output);
      }
    }
    return;
  }

  public ArrayList<String> showOptions(boolean isLoggedIn) {
    ArrayList<String> options = new ArrayList<String>();

    options.add("List Books");
    options.add("List Movies");

    if (isLoggedIn) {
      options.add("Checkout Book");
      options.add("Checkout Movie");
      options.add("Return Book");
      options.add("Return Movie");
      options.add("View Profile");
    } else {
      options.add("Log In");
    }
    options.add("Quit");

    return options;
  }

  private void initializeLibrary() {
    bookLibrary.addNewItem(new Book("Head First Java", "Kathy Sierra", 2005));
    bookLibrary.addNewItem(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    bookLibrary.addNewItem(new Book("Test Driven Development", "Kent Beck", 2002));
    bookLibrary.addNewItem(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    bookLibrary.addNewItem(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    bookLibrary.addNewItem(new Book("The 5 Love Languages", "Gary Chapman", 1995));

    movieLibrary.addNewItem(new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015));
    movieLibrary.addNewItem(new Movie("Reservoir Dogs", "Quentin Tarantino", 1992));
  }

  private void initializeUserList() {
    userList.add(new User("John Doe", "john@doe.com", 87654321, 123456, "password"));
    userList.add(new User("Jane Doe", "jane@doe.com", 91234567, 654321, "secret"));
  }
}
