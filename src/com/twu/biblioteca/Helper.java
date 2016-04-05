package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by albert on 5/4/16.
 */
public class Helper {
  public String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + " ");

    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0) return null;
    } catch (IOException e) {
      System.out.println("IOException " + e);
    }

    return inputLine;
  }

  public void displayText(String output) {
    System.out.println(output);
  }
}
