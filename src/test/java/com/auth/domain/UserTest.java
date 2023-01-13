package com.auth.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.auth.domain.entities.User;
import com.auth.domain.entities.errors.InvalidPasswordException;
import com.auth.domain.entities.errors.InvalidUsernameException;
import com.auth.domain.errors.ValidationError;
import com.auth.shared.Either;

public class UserTest {
  @Test
  public void shouldCreateUser() {
    String inputValidUsername = "validusername";
    String inputValidPassword = "12345678";
    Either<ValidationError, User> createdUser = User.create(inputValidUsername, inputValidPassword);
    assertEquals(createdUser.getRight().username.value, inputValidUsername);
  }

  @Test
  public void shouldThrowErrorIfUsernameIsInvalid() {
    String inputInvalidUsername = "invalid username";
    String inputValidPassword = "12345678";
    Either<ValidationError, User> error = User.create(inputInvalidUsername, inputValidPassword);
    assertTrue(error.isLeft());
    assertEquals(error.getLeft().getMessage(), new InvalidUsernameException().getMessage());
  }

  @Test
  public void shouldThrowErrorIfPasswordIsInvalid() {
    String inputValidUsername = "validusername";
    String inputInvalidPassword = "1234567";
    Either<ValidationError, User> error = User.create(inputValidUsername, inputInvalidPassword);
    assertTrue(error.isLeft());
    assertEquals(error.getLeft().getMessage(), new InvalidPasswordException().getMessage());
  }
}
