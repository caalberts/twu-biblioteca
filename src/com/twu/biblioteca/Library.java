package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by albert on 5/4/16.
 */
public class Library {
  private ArrayList<Book> books = new ArrayList<Book>();

  Library() {
    books.add(new Book("Head First Java", "Kathy Sierra", 2005));
    books.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
    books.add(new Book("Test Driven Development", "Kent Beck", 2002));
    books.add(new Book("A Game of Thrones", "George R. R. Martin", 1996));
    books.add(new Book("Blink: The Power of Thinking Without Thinking", "Malcolm Gladwell", 2005));
    books.add(new Book("The 5 Love Languages", "Gary Chapman", 1995));
  }

  public ArrayList<Book> listBooks() {
    return books;
  }

  public void addNewBook(Book newBook) {
    books.add(newBook);
  }
}
