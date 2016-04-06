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
    assertTrue(lib.checkout("A Game of Thrones"));
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
  }

  @Test
  public void checkoutFailsWhenBookIsNotAvailable() {
    Library lib = new Library();
    lib.checkout("A Game of Thrones");
    assertFalse(lib.checkout("A Game of Thrones"));
  }

  @Test
  public void checkoutFailsWhenBookTitleIsNotFound() {
    Library lib = new Library();
    assertFalse(lib.checkout("A Gme of Thorns"));
  }

  @Test
  public void listAvailableBooks() {
    Library lib = new Library();
    int totalBooks = lib.listBooks().size();
    lib.checkout("A Game of Thrones");
    lib.checkout("Test Driven Development");
    assertEquals(lib.listAvailableBooks().size(), totalBooks - 2);
  }

  @Test
  public void findABookByItsTitle() {
    Library lib = new Library();
    Book book = lib.findBookByTitle("A Game of Thrones");
    assertEquals(book.getAuthor(), "George R. R. Martin");
    assertEquals(book.getYear(), 1996);
  }

  @Test
  public void returnBookToLibrary() {
    Library lib = new Library();
    lib.checkout("A Game of Thrones");
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
    lib.returnBook("A Game of Thrones");
    assertTrue(lib.findBookByTitle("A Game of Thrones").isAvailable());
  }

  @Test
  public void returnFailsWhenTitleIsMisspelt() {
    Library lib = new Library();
    lib.checkout("A Game of Thrones");
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
    assertFalse(lib.returnBook("A Gme of Thrnes"));
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
  }

  @Test
  public void returnFailsWhenBookIsNotCheckedOut() {
    Library lib = new Library();
    assertTrue(lib.findBookByTitle("A Game of Thrones").isAvailable());
    assertFalse(lib.returnBook("A Game of Thrones"));
  }
}