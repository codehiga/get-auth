package com.auth.domain.entities;

import com.auth.domain.entities.errors.InvalidPasswordException;
import com.auth.shared.Either;

public class Password {
  public String value;

  private Password(String password) {
    this.value = password;
  }

  public static Either<InvalidPasswordException, Password> create(String password) {
    boolean isValidPassword = isValidPassword(password);
    if(!isValidPassword) {
      return Either.left(new InvalidPasswordException());
    }
    return Either.right(new Password(password));
  }

  public static boolean isValidPassword(String password) {
    if(password.length() > 64 || password.length() < 8) {
      return false;
    }
    return true;
  }
}
