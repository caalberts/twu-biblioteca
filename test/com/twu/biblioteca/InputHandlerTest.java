package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 6/4/16.
 */
public class InputHandlerTest {
  Library lib;
  InputHandler handler;

  @Before
  public void prepareTest() {
    lib = new Library();
    lib.addNewBook(new Book("Head First Java", "Kathy Sierra", 2005));
    lib.addNewBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    handler = new InputHandler();
  }

  @Test
  public void listBooks() {
    handler.process("List Books", lib);
    assertTrue(handler.getOutput().contains("Books available for loan:"));
    assertTrue(handler.getOutput().contains("Head First Java"));
    assertTrue(handler.getOutput().contains("Kathy Sierra"));
    assertTrue(handler.getOutput().contains("2005"));
    assertTrue(handler.getOutput().contains("Harry Potter and the Philosopher's Stone"));
    assertTrue(handler.getOutput().contains("J. K. Rowling"));
    assertTrue(handler.getOutput().contains("1997"));
  }

  @Test
  public void invalidOption() {
    handler.process("InvalidOption", lib);
    assertEquals(handler.getOutput(), "Select a valid option!");
  }
}