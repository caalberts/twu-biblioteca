package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 7/4/16.
 */
public class UserTest {
  @Test
  public void userHasNameEmailPhone(){
    User user = new User("John Doe", "john@doe.com", 87654321);
    assertEquals(user.getName(), "John Doe");
    assertEquals(user.getEmail(), "john@doe.com");
    assertEquals(user.getPhone(), 87654321);
  }
}