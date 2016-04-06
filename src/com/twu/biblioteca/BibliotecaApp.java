package com.twu.biblioteca;

public class BibliotecaApp {
  private String userCommand = "";
  private InputHandler handler = new InputHandler();
  private Helper helper = new Helper();
  private Library library = new Library();


  public void start() {
    initializeLibrary();

    System.out.println("Welcome to Biblioteca.\n");

    while (!userCommand.equals("Quit")) {
      String prompt = "How can I help you?\n" +
          "Type any of the following commands:\n" +
          "1. 'List Books'\n" +
          "2. 'Checkout'\n" +
          "3. 'Return'\n" +
          "4. 'Quit'\n";
      userCommand = helper.getUserInput(prompt);

      String output = handler.process(userCommand, library);
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
  }
}
