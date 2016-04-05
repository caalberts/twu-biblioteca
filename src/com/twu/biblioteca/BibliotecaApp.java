package com.twu.biblioteca;

public class BibliotecaApp {

  private String promptMessage = "Welcome to Biblioteca.";


  public String getPromptMessage() {
    return promptMessage;
  }

  public void start() {
    System.out.println(promptMessage);
  }
}
