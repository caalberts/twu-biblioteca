package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

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
  }

  @Test
  public void checkoutBookFromLibrary() {
    Library lib = new Library();
    assertTrue(lib.checkout(lib.listBooks().get(0)));
    assertFalse(lib.listBooks().get(0).isAvailable());
  }

  @Test
  public void failedCheckout() {
    Library lib = new Library();
    lib.checkout(lib.listBooks().get(0));
    assertFalse(lib.checkout(lib.listBooks().get(0)));
  }

  @Test
  public void listAvailableBooks() {
    Library lib = new Library();
    int totalBooks = lib.listBooks().size();
    lib.checkout(lib.listBooks().get(0));
    lib.checkout(lib.listBooks().get(2));
    assertEquals(lib.listAvailableBooks().size(), totalBooks - 2);
  }

  @Test
  public void findABookByItsTitle() {
    Library lib = new Library();
    Book book = lib.findBookByTitle("A Game of Thrones");
    assertEquals(book.getAuthor(), "George R. R. Martin");
    assertEquals(book.getYear(), 1996);
  }
}