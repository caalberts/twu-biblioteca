package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 7/4/16.
 */
public class MovieLibraryTest {
  Library<Movie> lib;

  @Before
  public void initializeLibraryForTest() {
    lib = new Library<>();

    lib.addNewItem(new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015));
    lib.addNewItem(new Movie("Reservoir Dogs", "Quentin Tarantino", 1992));
  }

  @Test
  public void listAllMoviesInLibrary() {
    assertTrue(lib.getAllItems().size() == 2);
    assertTrue(lib.getLoanedItems().size() == 0);
  }

  @Test
  public void addNewMovieToLibrary() {
    Movie newMovie = new Movie("This is a new movie", "you", 2016);
    lib.addNewItem(newMovie);
    assertTrue(lib.getAllItems().contains(newMovie));
  }

  @Test
  public void checkIfMovieIsAvailable() {
    assertTrue(lib.isItemAvailable("Reservoir Dogs"));
    assertFalse(lib.isItemAvailable("Inglorious Basterds"));
  }

  @Test
  public void MovieIsNotAvailableIfLoaned() {
    lib.checkoutItem("Reservoir Dogs");
    assertFalse(lib.isItemAvailable("Reservoir Dogs"));
  }

  @Test
  public void checkIfMovieIsLoaned() {
    lib.checkoutItem("Reservoir Dogs");
    assertTrue(lib.isItemLoaned("Reservoir Dogs"));
    assertFalse(lib.isItemLoaned("Star Wars: The Force Awakens"));
  }

  @Test
  public void checkoutMovie() {
    lib.checkoutItem("Reservoir Dogs");
    assertEquals(lib.getAvailableItems().size(), 1);
    assertEquals(lib.getLoanedItems().size(), 1);
    assertFalse(lib.isItemAvailable("Reservoir Dogs"));
  }

  @Test
  public void returnMovie() {
    lib.checkoutItem("Reservoir Dogs");
    assertFalse(lib.isItemAvailable("Reservoir Dogs"));
    lib.returnItem("Reservoir Dogs");
    assertEquals(lib.getAvailableItems().size(), 2);
    assertEquals(lib.getLoanedItems().size(), 0);
    assertTrue(lib.isItemAvailable("Reservoir Dogs"));
  }

  @Test
  public void findAMovieByItsTitle() {
    Movie movie = lib.findItemByTitle("Reservoir Dogs");
    assertEquals(movie.getDirector(), "Quentin Tarantino");
    assertEquals(movie.getYear(), 1992);
  }

}
