package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by albert on 7/4/16.
 */
public class AuthenticatorTest {
  User authUser;
  ArrayList<User> userList;
  Authenticator auth;

  @Before
  public void prepareTest() {
    authUser = new User("John Doe", "john@doe.com", 87654321, 123456, "password");
    userList = new ArrayList<>();
    userList.add(authUser);
  }

  @Test
  public void successfulLogin() {
    auth = new Authenticator("123456", "password", userList);
    assertEquals(auth.findUser(), authUser);
    assertTrue(auth.isSuccessfulLogin());
  }

  @Test
  public void failedLogin() {
    auth = new Authenticator("123456", "secret", userList);
    assertEquals(auth.findUser(), authUser);
    assertFalse(auth.isSuccessfulLogin());
  }

  @Test
  public void userNotFound() {
    auth = new Authenticator("99999", "password", userList);
    assertEquals(auth.findUser(), null);
  }
}