package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by albert on 5/4/16.
 */
public class Library {
  private ArrayList<Book> availableBooks = new ArrayList<Book>();
  private ArrayList<Book> loanedBooks = new ArrayList<Book>();

  private ArrayList<Movie> availableMovies = new ArrayList<Movie>();
  private ArrayList<Movie> loanedMovies = new ArrayList<Movie>();

  public ArrayList<Book> getAvailableBooks() {
    return availableBooks;
  }

  public ArrayList<Book> getLoanedBooks() {
    return loanedBooks;
  }

  public ArrayList<Book> getAllBooks() {
    ArrayList<Book> allBooks = new ArrayList<Book>();
    allBooks.addAll(availableBooks);
    allBooks.addAll(loanedBooks);
    return allBooks;
  }

  public ArrayList<Movie> getAvailableMovies() {
    return availableMovies;
  }

  public ArrayList<Movie> getLoanedMovies() {
    return loanedMovies;
  }

  public ArrayList<Movie> getAllMovies() {
    ArrayList<Movie> allMovies = new ArrayList<Movie>();
    allMovies.addAll(availableMovies);
    allMovies.addAll(loanedMovies);
    return allMovies;
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
    for (Book book : getAllBooks()) {
      if (book.getTitle().equals(title)) {
        return book;
      }
    }
    return null;
  }

  public void addNewBook(Book newBook) {
    availableBooks.add(newBook);
  }

  public void addNewMovie(Movie newMovie) {
    availableMovies.add(newMovie);
  }

  public void checkoutBook(String title) {
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
