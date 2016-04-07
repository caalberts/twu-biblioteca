package com.twu.biblioteca;

/**
 * Created by albert on 7/4/16.
 */
public class InventoryItem {
  private String title;
  private int year;

  public InventoryItem(String itemTitle, int itemYear) {
    title = itemTitle;
    year = itemYear;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }
}
