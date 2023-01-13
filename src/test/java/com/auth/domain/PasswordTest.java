package com.auth.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.auth.domain.entities.Password;
import com.auth.domain.entities.errors.InvalidPasswordException;
import com.auth.shared.Either;

public class PasswordTest {
  @Test
  public void shouldCreatePassword() {
    String inputPassword = "12345678";
    Either<InvalidPasswordException, Password> createdPassword = Password.create(inputPassword);
    assertEquals(createdPassword.getRight().value, inputPassword);
  }

  @Test
  public void shouldThrowInvalidPasswordException() {
    String invalidInputPassword = "123456";
    Either<InvalidPasswordException, Password> error = Password.create(invalidInputPassword);
    assertTrue(error.isLeft());
    assertEquals(error.getLeft().getMessage(), new InvalidPasswordException().getMessage());
  }
}
