package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by albert on 7/4/16.
 */
public class Authenticator {
  private ArrayList<User> userList;
  private String libraryNumber;
  private String password;

  public Authenticator(String inputNumber, String inputPassword, ArrayList<User> allUsers) {
    libraryNumber = inputNumber;
    password = inputPassword;
    userList = allUsers;
  }

  public boolean isSuccessfulLogin() {
    for (User user : userList) {
      if (user.getLibraryNumber() == Integer.parseInt(libraryNumber, 10)) {
        if (user.getPassword().equals(password)) {
          return true;
        }
      }
    }
    return false;
  }

  public User findUser() {
    for (User user : userList) {
      if (user.getLibraryNumber() == Integer.parseInt(libraryNumber, 10)) {
        return user;
      }
    }
    return null;
  }
}
