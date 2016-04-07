package com.twu.biblioteca;

public class BibliotecaApp {
  private InputHandler handler;
  private Helper helper = new Helper();
  private Library library = new Library();


  public void start() {
    String userCommand = "";
    initializeLibrary();
    handler = new InputHandler(library, helper);

    System.out.println("Welcome to Biblioteca.\n");

    while (!userCommand.equals("Quit")) {
      String prompt = "How can I help you?\n" +
          "Type any of the following commands:\n" +
          "1. 'List Books'\n" +
          "2. 'List Movies'\n" +
          "3. 'Checkout'\n" +
          "4. 'Return'\n" +
          "5. 'Quit'\n";
      userCommand = helper.getUserInput(prompt);

      String output = handler.process(userCommand);
      System.out.println(output);
    }
    return;
  }

  private void initializeLibrary() {
    library.addNewBook(new Book("Head First Java", "Kathy Sierra", 2005));
    library.addNewBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    library.addNewBook(new Book("Test Driven Development", "Kent Beck", 2002));
    library.addNewBook(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    library.addNewBook(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    library.addNewBook(new Book("The 5 Love Languages", "Gary Chapman", 1995));

    library.addNewMovie(new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015));
    library.addNewMovie(new Movie("Reservoir Dogs", "Quentin Tarantino", 1992));
  }
}
