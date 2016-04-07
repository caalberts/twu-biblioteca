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
  Helper helper;

  @Before
  public void prepareTest() {
    lib = new Library();
    helper = new Helper();
    lib.addNewBook(new Book("Head First Java", "Kathy Sierra", 2005));
    lib.addNewBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    handler = new InputHandler(lib, helper);
  }

  @Test
  public void listBooks() {
    String result = handler.process("List Books");
    assertTrue(result.contains("Books available for loan:"));
    assertTrue(result.contains("Head First Java"));
    assertTrue(result.contains("Kathy Sierra"));
    assertTrue(result.contains("2005"));
    assertTrue(result.contains("Harry Potter and the Philosopher's Stone"));
    assertTrue(result.contains("J. K. Rowling"));
    assertTrue(result.contains("1997"));
  }

  @Test
  public void checkoutBook() {
    handler.process("List Books");
    assertEquals(handler.handleCheckout("Head First Java"), "Thank you, enjoy the book.");
    assertEquals(handler.handleCheckout("Missing Book"), "That book is not available.");
  }

  @Test
  public void returnBook() {
    handler.process("List Books");
    assertEquals(handler.handleCheckout("Head First Java"), "Thank you, enjoy the book.");
    assertEquals(handler.handleReturn("Head First Java"), "Thank you for returning the book.");
    assertEquals(handler.handleReturn("A Game of Thrones"), "That is not a valid book to return.");
  }

  @Test
  public void invalidOption() {
    assertEquals(handler.process("InvalidOption"), "Select a valid option!");
  }
}