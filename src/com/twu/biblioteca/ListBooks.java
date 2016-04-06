package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by albert on 6/4/16.
 */
public class ListBooks {
  public static void display(ArrayList<Book> books) {
    System.out.println("Books available for loan:\n");
    for (Book book : books) {
      String bookDetails = book.getTitle() + " by " +
          book.getAuthor() +
          " (" + book.getYear() +")";
      System.out.println(bookDetails);
    }
    System.out.println("\n");
  }
}
