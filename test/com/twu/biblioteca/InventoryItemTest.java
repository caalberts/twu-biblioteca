package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 7/4/16.
 */
public class InventoryItemTest {
  @Test
  public void itemHasTitleAndYear() {
    InventoryItem harryPotter = new InventoryItem("Harry Potter and the Philosopher's Stone", 1997);
    assertEquals(harryPotter.getTitle(), "Harry Potter and the Philosopher's Stone");
    assertEquals(harryPotter.getYear(), 1997);
  }
}