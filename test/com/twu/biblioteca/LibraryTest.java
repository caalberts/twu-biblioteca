package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

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
    assertTrue(lib.listAvailableBooks().size() == 6);
    assertTrue(lib.listLoanedBooks().size() == 0);
  }

  @Test
  public void addNewBookToLibrary() {
    Book newBook = new Book("This is a new book", "me", 2016);
    lib.addNewBook(newBook);
    assertTrue(lib.listAllBooks().contains(newBook));
  }

  @Test
  public void checkIfBookIsAvailable() {
    assertTrue(lib.isAvailable("A Game of Thrones"));
    assertFalse(lib.isAvailable("A Gme of Thorns"));
  }

  @Test
  public void checkIfBookIsLoaned() {
    lib.checkoutBook("A Game of Thrones");
    assertTrue(lib.isLoaned("A Game of Thrones"));
    assertFalse(lib.isLoaned("Test Driven Development"));
  }


  @Test
  public void checkoutBook() {
    lib.checkoutBook("A Game of Thrones");
    assertEquals(lib.listAvailableBooks().size(), 5);
    assertEquals(lib.listLoanedBooks().size(), 1);
    assertFalse(lib.isAvailable("A Game of Thrones"));
  }

  @Test
  public void returnBook() {
    lib.checkoutBook("A Game of Thrones");
    assertFalse(lib.isAvailable("A Game of Thrones"));
    lib.returnBook("A Game of Thrones");
    assertEquals(lib.listAvailableBooks().size(), 6);
    assertEquals(lib.listLoanedBooks().size(), 0);
    assertTrue(lib.isAvailable("A Game of Thrones"));
  }

  @Test
  public void findABookByItsTitle() {
    Book book = lib.findBookByTitle("A Game of Thrones");
    assertEquals(book.getAuthor(), "George R. R. Martin");
    assertEquals(book.getYear(), 1996);
  }
}