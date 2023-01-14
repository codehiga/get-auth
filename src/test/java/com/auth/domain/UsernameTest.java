package com.auth.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.auth.application.domain.entities.Username;
import com.auth.application.domain.entities.errors.InvalidUsernameException;
import com.auth.shared.Either;


public class UsernameTest {
  @Test
  public void shouldCreateValidUsername() {
    String usernameInput = "validusername";
    Either<InvalidUsernameException, Username> createdUsername = Username.create(usernameInput);
    assertEquals(createdUsername.getRight().value, usernameInput);
  }

  @Test
  public void shouldThrowInvalidUsernameException() {
    String usernameInput = "invalid username";
    Either<InvalidUsernameException, Username> error = Username.create(usernameInput);
    assertTrue(error.isLeft());
    assertEquals(error.getLeft().getMessage(), new InvalidUsernameException().getMessage());
  }

  @Test
  public void shouldThrowInvalidUsernameExceptionIfUsernameContainsSpecialCharacters() {
    String usernameInput = "invalid@username";
    Either<InvalidUsernameException, Username> error = Username.create(usernameInput);
    assertTrue(error.isLeft());
    assertEquals(error.getLeft().getMessage(), new InvalidUsernameException().getMessage());
  }
}
