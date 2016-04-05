package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by albert on 5/4/16.
 */
public class Library {
  private ArrayList<Book> books = new ArrayList<Book>();

  Library() {
    books.add(new Book("Head First Java", "O'Reilly", 2005));
  }

  public ArrayList<Book> listBooks() {
    return books;
  }

  public void addNewBook(Book newBook) {
    books.add(newBook);
  }
}
