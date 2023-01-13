package com.auth.domain.entities;

import com.auth.domain.entities.errors.InvalidUsernameException;

public class Username {
  public String value;

  private Username(String username) {
    this.value = username;
  }

  public static Username create(String username) {
    boolean isValidUsername = isValid(username);
    if(!isValidUsername) {
      throw new InvalidUsernameException();
    }
    return new Username(username);
  }

  private static boolean isValid(String username) {
    if(username.isEmpty() | username.isBlank()) {
      return false;
    }
    if(username.contains(" ")) {
      return false;
    }
    if(username.length() > 64 | username.length() < 3) {
      return false;
    }
    return true;
  }

}
