package com.auth.domain.entities;

public class User {
  public Username username;
  public Password password;

  private User(Username username, Password password) {
    this.username = username;
    this.password = password;
  }

  public static User create(String username, String password) {
    Username usernameOrError;
    Password passwordOrError;
    try {
      usernameOrError = Username.create(username);
    } catch(Error error) {
      throw new Error(error.getMessage());
    }
    try {
      passwordOrError = Password.create(password);
    } catch(Error error) {
      throw new Error(error.getMessage());
    }
    return new User(usernameOrError, passwordOrError);
  }
}
