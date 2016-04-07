package com.twu.biblioteca;

/**
 * Created by albert on 7/4/16.
 */
public class Movie extends InventoryItem {
  private String director;

  public Movie(String movieTitle, String movieDirector, int movieYear) {
    super(movieTitle, movieYear);
    director = movieDirector;
  }

  public String getDirector() {
    return director;
  }
}
