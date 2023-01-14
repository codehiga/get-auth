package com.auth.application.domain.entities;

import com.auth.application.domain.entities.errors.InvalidUsernameException;
import com.auth.shared.Either;

public class Username {
  public String value;

  private Username(String username) {
    this.value = username;
  }

  public static Either<InvalidUsernameException, Username> create(String username) {
    boolean isValidUsername = isValid(username);
    if(!isValidUsername) {
      return Either.left(new InvalidUsernameException());
    }
    return Either.right(new Username(username));
  }

  private static boolean isValid(String username) {
    if(username.isEmpty()) {
      return false;
    }
    if(username.contains(" ")) {
      return false;
    }
    if(username.length() > 64 | username.length() < 3) {
      return false;
    }
    if(username.matches(".*[^a-zA-Z0-9].*")){
      return false;
    }
    return true;
  }

}
