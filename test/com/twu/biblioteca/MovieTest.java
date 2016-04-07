package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 7/4/16.
 */
public class MovieTest {
  @Test
  public void movieHasTitleDirectorYear() {
    Movie starWars = new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015);
    assertEquals(starWars.getTitle(), "Star Wars: The Force Awakens");
    assertEquals(starWars.getDirector(), "J. J. Abrams");
    assertEquals(starWars.getYear(), 2015);
  }
}