package com.auth.domain.entities;

import com.auth.domain.entities.errors.InvalidPasswordException;

public class Password {
  public String password;

  private Password(String password) {
    this.password = password;
  }

  public static Password create(String password) {
    boolean isValidPassword = isValidPassword(password);
    if(!isValidPassword) {
      throw new InvalidPasswordException();
    }
    return new Password(password);
  }

  public static boolean isValidPassword(String password) {
    if(password.length() > 64 || password.length() < 8) {
      return false;
    }
    return true;
  }
}
