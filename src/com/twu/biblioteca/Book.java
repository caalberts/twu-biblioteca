package com.twu.biblioteca;

/**
 * Created by albert on 5/4/16.
 */
public class Book extends InventoryItem {
  private String author;

  public Book(String bookTitle, String bookAuthor, int bookYear) {
    super(bookTitle, bookYear);
    author = bookAuthor;
  }

  public String getAuthor() {
    return author;
  }
}
