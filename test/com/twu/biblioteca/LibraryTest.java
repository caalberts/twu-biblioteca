package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 5/4/16.
 */
public class LibraryTest {
  @Test
  public void listBooksInLibrary() {
    Library lib = new Library();

    assertTrue(lib.listBooks().size() > 0);
  }

  @Test
  public void addNewBookToLibrary() {
    Library lib = new Library();

    Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);
    lib.addNewBook(harryPotter);
    assertTrue(lib.listBooks().contains(harryPotter));
  }
}