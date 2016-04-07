package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 7/4/16.
 */
public class BookLibraryTest {
  Library<Book> lib;

  @Before
  public void initializeLibraryForTest() {
    lib = new Library<Book>();
    lib.addNewItem(new Book("Head First Java", "Kathy Sierra", 2005));
    lib.addNewItem(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    lib.addNewItem(new Book("Test Driven Development", "Kent Beck", 2002));
    lib.addNewItem(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    lib.addNewItem(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    lib.addNewItem(new Book("The 5 Love Languages", "Gary Chapman", 1995));
  }

  @Test
  public void listAllBooksInLibrary() {
    assertTrue(lib.getAvailableItems().size() == 6);
    assertTrue(lib.getLoanedItems().size() == 0);
  }

  @Test
  public void addNewBookToLibrary() {
    Book newBook = new Book("This is a new book", "me", 2016);
    lib.addNewItem(newBook);
    assertTrue(lib.getAllItems().contains(newBook));
  }

  @Test
  public void checkIfBookIsAvailable() {
    assertTrue(lib.isItemAvailable("A Game of Thrones"));
    assertFalse(lib.isItemAvailable("A Gme of Thorns"));
  }

  @Test
  public void bookIsNotAvailableIfLoaned() {
    lib.checkoutItem("A Game of Thrones");
    assertFalse(lib.isItemAvailable("A Game of Thrones"));
  }

  @Test
  public void checkIfBookIsLoaned() {
    lib.checkoutItem("A Game of Thrones");
    assertTrue(lib.isItemLoaned("A Game of Thrones"));
    assertFalse(lib.isItemLoaned("Test Driven Development"));
  }

  @Test
  public void checkoutItem() {
    lib.checkoutItem("A Game of Thrones");
    assertEquals(lib.getAvailableItems().size(), 5);
    assertEquals(lib.getLoanedItems().size(), 1);
    assertFalse(lib.isItemAvailable("A Game of Thrones"));
  }

  @Test
  public void returnItem() {
    lib.checkoutItem("A Game of Thrones");
    assertFalse(lib.isItemAvailable("A Game of Thrones"));
    assertEquals(lib.getAvailableItems().size(), 5);
    assertEquals(lib.getLoanedItems().size(), 1);
    lib.returnItem("A Game of Thrones");
    assertEquals(lib.getAvailableItems().size(), 6);
    assertEquals(lib.getLoanedItems().size(), 0);
    assertTrue(lib.isItemAvailable("A Game of Thrones"));
  }

  @Test
  public void findABookByItsTitle() {
    Book book = lib.findItemByTitle("A Game of Thrones");
    assertEquals(book.getAuthor(), "George R. R. Martin");
    assertEquals(book.getYear(), 1996);
  }
}