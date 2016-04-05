package com.twu.biblioteca;

public class BibliotecaApp {

  private String promptMessage = "";
  private String input = "";

  private String output = "Welcome to Biblioteca.";
  Helper helper = new Helper();
  Library library = new Library();


  public String getPromptMessage() {
    return promptMessage;
  }

  public void start() {
    helper.displayText(output);
    displayLibrary();
    while (!input.equals("Quit")) {
      promptMessage = "How can I help you?\nType 'Quit' to leave Biblioteca.";
      input = helper.getUserInput(promptMessage);

    }
    return;
  }

  public void displayLibrary() {
    for (Book book : library.listBooks()) {
      output = "Title: " + book.getTitle() + "\n" +
               "Author: " + book.getAuthor() + "\n" +
               "Publication Year: " + book.getYear() +"\n";
      helper.displayText(output);
    }
  }

  public String getOutput() {
    return output;
  }

}
