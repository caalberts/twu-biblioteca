package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by albert on 5/4/16.
 */
public class Library {
  private ArrayList<Book> availableBooks = new ArrayList<Book>();
  private ArrayList<Book> loanedBooks = new ArrayList<Book>();

  public ArrayList<Book> listAllBooks() {
    ArrayList<Book> allBooks = new ArrayList<Book>();
    allBooks.addAll(availableBooks);
    allBooks.addAll(loanedBooks);
    return allBooks;
  }

  public ArrayList<Book> listAvailableBooks() {
    return availableBooks;
  }

  public ArrayList<Book> listLoanedBooks() {
    return loanedBooks;
  }

  public boolean isAvailable(String title) {
    Book book = findBookByTitle(title);

    return availableBooks.contains(book) && !loanedBooks.contains(book);
  }

  public boolean isLoaned(String title) {
    Book book = findBookByTitle(title);
    return loanedBooks.contains(book);
  }

  public Book findBookByTitle (String title) {
    for (Book book : listAllBooks()) {
      if (book.getTitle().equals(title)) {
        return book;
      }
    }
    return null;
  }

  public void addNewBook(Book newBook) {
    availableBooks.add(newBook);
  }

  public void checkout(String title) {
    Book book = findBookByTitle(title);
    availableBooks.remove(availableBooks.indexOf(book));
    loanedBooks.add(book);
  }

  public void returnBook(String title) {
    Book book = findBookByTitle(title);
    loanedBooks.remove(loanedBooks.indexOf(book));
    availableBooks.add(book);
  }
}
