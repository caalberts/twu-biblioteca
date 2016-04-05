package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 5/4/16.
 */
public class LibraryTest {
  @Test
  public void listAllBooksInLibrary() {
    Library lib = new Library();

    assertTrue(lib.listBooks().size() > 0);
  }

  @Test
  public void addNewBookToLibrary() {
    Library lib = new Library();

    Book newBook = new Book("This is a new book", "me", 2016);
    lib.addNewBook(newBook);
    assertTrue(lib.listBooks().contains(newBook));
  }w
}