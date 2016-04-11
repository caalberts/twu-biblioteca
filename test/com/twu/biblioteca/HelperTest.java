package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by albert on 11/4/16.
 */
public class HelperTest {
  @Test
  public void loggedInOptions() {
    ArrayList options = Helper.showOptions(true);
    assertTrue(options.contains("List Books"));
    assertTrue(options.contains("List Movies"));
    assertTrue(options.contains("Checkout Book"));
    assertTrue(options.contains("Checkout Movie"));
    assertTrue(options.contains("Return Book"));
    assertTrue(options.contains("Return Movie"));
    assertTrue(options.contains("View Profile"));
    assertTrue(options.contains("Quit"));
  }

  @Test
  public void loggedOutOptions() {
    ArrayList options = Helper.showOptions(false);
    assertTrue(options.contains("List Books"));
    assertTrue(options.contains("List Movies"));
    assertFalse(options.contains("Checkout Book"));
    assertFalse(options.contains("Checkout Movie"));
    assertFalse(options.contains("Return Book"));
    assertFalse(options.contains("Return Movie"));
    assertFalse(options.contains("View Profile"));
    assertTrue(options.contains("Log In"));
    assertTrue(options.contains("Quit"));
  }
}