package com.auth.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.auth.application.domain.entities.Password;
import com.auth.application.domain.entities.errors.InvalidPasswordException;
import com.auth.shared.Either;

public class PasswordTest {
  @Test
  public void shouldCreatePassword() {
    String inputPassword = "12345678";
    Either<InvalidPasswordException, Password> createdPassword = Password.create(inputPassword);
    String passHash = createdPassword.getRight().value;
    assertNotEquals(passHash, "");
    assertTrue(createdPassword.isRight());
  }

  @Test
  public void shouldThrowInvalidPasswordException() {
    String invalidInputPassword = "123456";
    Either<InvalidPasswordException, Password> error = Password.create(invalidInputPassword);
    assertTrue(error.isLeft());
    assertEquals(error.getLeft().getMessage(), new InvalidPasswordException().getMessage());
  }
}
