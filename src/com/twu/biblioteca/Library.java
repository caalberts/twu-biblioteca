package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by albert on 5/4/16.
 */
public class Library {
  private ArrayList<Book> inventory = new ArrayList<Book>();

  Library() {
    inventory.add(new Book("Head First Java", "Kathy Sierra", 2005));
    inventory.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    inventory.add(new Book("Test Driven Development", "Kent Beck", 2002));
    inventory.add(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    inventory.add(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    inventory.add(new Book("The 5 Love Languages", "Gary Chapman", 1995));
  }

  public ArrayList<Book> listBooks() {
    return inventory;
  }

  public ArrayList<Book> listAvailableBooks() {
    ArrayList<Book> availableBooks = new ArrayList<Book>();
    for (Book book : inventory) {
      if (book.isAvailable()) availableBooks.add(book);
    }
    return availableBooks;
  }

  public Book findBookByTitle (String title) {
    for (Book book : this.listBooks()) {
      if (book.getTitle().equals(title)) {
        return book;
      }
    }
    return null;
  }

  public void addNewBook(Book newBook) {
    inventory.add(newBook);
  }

  public boolean checkout(String title) {
    Book book = findBookByTitle(title);

    boolean checkoutStatus = false;
    if (book != null) {
      checkoutStatus = book.confirmCheckout();
    }
    return checkoutStatus;
  }

  public boolean returnBook(String title) {
    Book book = findBookByTitle(title);

    boolean returnStatus = false;
    if (book != null) {
      returnStatus = book.confirmReturn();
    }
    return returnStatus;
  }
}
