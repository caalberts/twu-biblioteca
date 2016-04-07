package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by albert on 7/4/16.
 */
public class Library<T extends InventoryItem> {
  private ArrayList<T> availableItems = new ArrayList<T>();
  private ArrayList<T> loanedItems = new ArrayList<T>();
  private HashMap<String, Integer> loanRegister = new HashMap<>();

  public ArrayList<T> getAvailableItems() {
    return availableItems;
  }

  public ArrayList<T> getLoanedItems() {
    return loanedItems;
  }

  public ArrayList<T> getAllItems() {
    ArrayList<T> allItems = new ArrayList<T>();
    allItems.addAll(availableItems);
    allItems.addAll(loanedItems);
    return allItems;
  }

  public boolean isItemAvailable(String title) {
    T item = findItemByTitle(title);
    return availableItems.contains(item);
  }

  public boolean isItemLoaned(String title) {
    T item = findItemByTitle(title);
    return loanedItems.contains(item);
  }

  public T findItemByTitle(String title) {
    for (T item : getAllItems()) {
      if (item.getTitle().equals(title)) {
        return item;
      }
    }
    return null;
  }

  public void addNewItem(T newItem) {
    availableItems.add(newItem);
  }

  public void checkoutItem(String title, int libraryNumber) {
    T item = findItemByTitle(title);
    availableItems.remove(availableItems.indexOf(item));
    loanedItems.add(item);
    loanRegister.put(title, libraryNumber);
  }

  public void returnItem(String title) {
    T item = findItemByTitle(title);
    loanedItems.remove(loanedItems.indexOf(item));
    availableItems.add(item);
    loanRegister.remove(title);
  }

  public int identifyBorrower(String title) {
    if (loanRegister.get(title) != null) return loanRegister.get(title);
    return 0;
  }
}
