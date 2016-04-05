package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 5/4/16.
 */
public class BookTest {
  @Test
  public void bookHasTitleAuthorYear() {
    Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);
    assertEquals(harryPotter.getTitle(), "Harry Potter and the Philosopher's Stone");
    assertEquals(harryPotter.getAuthor(), "J. K. Rowling");
    assertEquals(harryPotter.getYear(), 1997);
  }

  @Test
  public void newBookIsAvailableForLoan() {
    Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);
    assertTrue(harryPotter.isAvailable());
  }
}