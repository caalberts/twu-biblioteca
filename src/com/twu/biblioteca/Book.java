package com.twu.biblioteca;

/**
 * Created by albert on 5/4/16.
 */
public class Book {
  private String title;
  private String author;
  private int year;

  Book(String bookTitle, String bookAuthor, int bookYear) {
    title = bookTitle;
    author = bookAuthor;
    year = bookYear;
  }

  public String getTitle() {
    return title;
  }
  public String getAuthor() {
    return author;
  }
  public int getYear() {
    return year;
  }
}