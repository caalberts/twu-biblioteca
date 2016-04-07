package com.twu.biblioteca;

/**
 * Created by albert on 7/4/16.
 */
public class User {
  private String name;
  private String email;
  private int phone;
  private int libraryNumber;
  private String password;

  public User(String userName, String userEmail, int userPhone, int userLibraryNumber, String userPassword) {
    name = userName;
    email = userEmail;
    phone = userPhone;
    libraryNumber = userLibraryNumber;
    password = userPassword;
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

  public int getLibraryNumber() {
    return libraryNumber;
  }

  public String getPassword() {
    return password;
  }
}
