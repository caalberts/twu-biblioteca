package com.twu.biblioteca;

/**
 * Created by albert on 7/4/16.
 */
public class User {
  private String name;
  private String email;
  private int phone;

  public User(String userName, String userEmail, int userPhone) {
    name = userName;
    email = userEmail;
    phone = userPhone;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getPhone() {
    return phone;
  }
}
