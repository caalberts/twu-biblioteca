package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by albert on 5/4/16.
 */
public class Library {
  private ArrayList<Book> inventory = new ArrayList<Book>();

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
