package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by albert on 5/4/16.
 */
public class Helper {
  public static String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + " ");

    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
      inputLine = is.readLine().trim();
      if (inputLine.length() == 0) return null;
    } catch (IOException e) {
      System.out.println("IOException " + e);
    }

    return inputLine;
  }

  public static ArrayList<String> showOptions(boolean isLoggedIn) {
    ArrayList<String> options = new ArrayList<>();

    options.add("List Books");
    options.add("List Movies");

    if (isLoggedIn) {
      options.add("Checkout Book");
      options.add("Checkout Movie");
      options.add("Return Book");
      options.add("Return Movie");
      options.add("View Profile");
      options.add("Log Out");
    } else {
      options.add("Log In");
    }
    options.add("Quit");

    return options;
  }

  public static void initializeLibrary(Library<Book> bookLibrary, Library<Movie> movieLibrary) {
    bookLibrary.addNewItem(new Book("Head First Java", "Kathy Sierra", 2005));
    bookLibrary.addNewItem(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    bookLibrary.addNewItem(new Book("Test Driven Development", "Kent Beck", 2002));
    bookLibrary.addNewItem(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    bookLibrary.addNewItem(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    bookLibrary.addNewItem(new Book("The 5 Love Languages", "Gary Chapman", 1995));

    movieLibrary.addNewItem(new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015));
    movieLibrary.addNewItem(new Movie("Reservoir Dogs", "Quentin Tarantino", 1992));
  }

  public static void initializeUserList(ArrayList<User> userList) {
    userList.add(new User("John Doe", "john@doe.com", 87654321, 123456, "password"));
    userList.add(new User("Jane Doe", "jane@doe.com", 91234567, 654321, "secret"));
  }
}
