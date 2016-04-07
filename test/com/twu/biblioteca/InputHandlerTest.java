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
    lib.addNewMovie(new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015));
    lib.addNewMovie(new Movie("Reservoir Dogs", "Quentin Tarantino", 1992));
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
  public void listMovies() {
    String result = handler.process("List Movies");
    assertTrue(result.contains("The Force Awakens"));
    assertTrue(result.contains("J. J. Abrams"));
    assertTrue(result.contains("2015"));
    assertTrue(result.contains("Reservoir Dogs"));
    assertTrue(result.contains("Quentin Tarantino"));
    assertTrue(result.contains("1992"));
  }

  @Test
  public void checkoutBook() {
    assertEquals(handler.handleCheckoutBook("Head First Java"), "Thank you, enjoy the book.");
    assertEquals(handler.handleCheckoutBook("Head First Java"), "That book is not available.");
    assertEquals(handler.handleCheckoutBook("Missing Book"), "That book is not available.");
  }

  @Test
  public void checkoutMovie() {
    assertEquals(handler.handleCheckoutMovie("Reservoir Dogs"), "Thank you, enjoy the movie.");
    assertEquals(handler.handleCheckoutMovie("Reservoir Dogs"), "That movie is not available.");
    assertEquals(handler.handleCheckoutMovie("Missing Movie"), "That movie is not available.");
  }

  @Test
  public void returnBook() {
    assertEquals(handler.handleCheckoutBook("Head First Java"), "Thank you, enjoy the book.");
    assertEquals(handler.handleReturnBook("Head First Java"), "Thank you for returning the book.");
    assertEquals(handler.handleReturnBook("A Game of Thrones"), "That is not a valid book to return.");
  }

  @Test
  public void returnMovie() {
    assertEquals(handler.handleCheckoutMovie("Reservoir Dogs"), "Thank you, enjoy the movie.");
    assertEquals(handler.handleReturnMovie("Reservoir Dogs"), "Thank you for returning the movie.");
    assertEquals(handler.handleReturnMovie("Inglorious Basterds"), "That is not a valid movie to return.");
  }

  @Test
  public void invalidOption() {
    assertEquals(handler.process("InvalidOption"), "Select a valid option!");
  }
}