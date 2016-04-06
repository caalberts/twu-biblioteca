package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albert on 5/4/16.
 */
public class BibliotecaAppTest {
  @Test
  public void applicationShouldStartWithALibrary() {
    BibliotecaApp app = new BibliotecaApp();
    assertTrue(app.library.listBooks().size() > 0);
  }

  //TODO mock userCommand and test app
}