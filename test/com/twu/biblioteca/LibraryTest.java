package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by albert on 5/4/16.
 */
public class LibraryTest {
  Library lib;

  @Before
  public void initializeLibraryForTest() {
    lib = new Library();
    lib.addNewBook(new Book("Head First Java", "Kathy Sierra", 2005));
    lib.addNewBook(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    lib.addNewBook(new Book("Test Driven Development", "Kent Beck", 2002));
    lib.addNewBook(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    lib.addNewBook(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    lib.addNewBook(new Book("The 5 Love Languages", "Gary Chapman", 1995));
  }

  @Test
  public void listAllBooksInLibrary() {
    assertTrue(lib.listBooks().size() == 6);
  }

  @Test
  public void addNewBookToLibrary() {
    Book newBook = new Book("This is a new book", "me", 2016);
    lib.addNewBook(newBook);
    assertTrue(lib.listBooks().contains(newBook));
  }

  @Test
  public void checkoutBookFromLibrary() {
    assertTrue(lib.checkout("A Game of Thrones"));
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
  }

  @Test
  public void checkoutFailsWhenBookIsNotAvailable() {
    lib.checkout("A Game of Thrones");
    assertFalse(lib.checkout("A Game of Thrones"));
  }

  @Test
  public void checkoutFailsWhenBookTitleIsNotFound() {
    assertFalse(lib.checkout("A Gme of Thorns"));
  }

  @Test
  public void listAvailableBooks() {
    int totalBooks = lib.listBooks().size();
    lib.checkout("A Game of Thrones");
    lib.checkout("Test Driven Development");
    assertEquals(lib.listAvailableBooks().size(), totalBooks - 2);
  }

  @Test
  public void findABookByItsTitle() {
    Book book = lib.findBookByTitle("A Game of Thrones");
    assertEquals(book.getAuthor(), "George R. R. Martin");
    assertEquals(book.getYear(), 1996);
  }

  @Test
  public void returnBookToLibrary() {
    lib.checkout("A Game of Thrones");
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
    lib.returnBook("A Game of Thrones");
    assertTrue(lib.findBookByTitle("A Game of Thrones").isAvailable());
  }

  @Test
  public void returnFailsWhenTitleIsMisspelt() {
    lib.checkout("A Game of Thrones");
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
    assertFalse(lib.returnBook("A Gme of Thrnes"));
    assertFalse(lib.findBookByTitle("A Game of Thrones").isAvailable());
  }

  @Test
  public void returnFailsWhenBookIsNotCheckedOut() {
    assertTrue(lib.findBookByTitle("A Game of Thrones").isAvailable());
    assertFalse(lib.returnBook("A Game of Thrones"));
  }
}