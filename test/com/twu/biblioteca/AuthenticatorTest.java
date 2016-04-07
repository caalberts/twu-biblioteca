package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by albert on 7/4/16.
 */
public class AuthenticatorTest {
  @Test
  public void successfulLogin() {
    User authUser = new User("John Doe", "john@doe.com", 87654321, 123456, "password");
    ArrayList<User> userList = new ArrayList<>();
    userList.add(authUser);

    Authenticator auth = new Authenticator("123456", "password", userList);

    assertEquals(auth.findUser(), authUser);
    assertTrue(auth.isSuccessfulLogin());
  }
}