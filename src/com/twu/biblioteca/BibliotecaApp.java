package com.twu.biblioteca;

public class BibliotecaApp {

  private String promptMessage = "Welcome to Biblioteca.";
  private String input = "";
  Helper helper = new Helper();


  public String getPromptMessage() {
    return promptMessage;
  }

  public void start() {
    System.out.println(promptMessage);
    while (!input.equals("Quit")) {
      promptMessage = "How can I help you?\nType 'Quit' to leave Biblioteca.";
      input = helper.getUserInput(promptMessage);
      System.out.println(input);
    }
    return;
  }
}
