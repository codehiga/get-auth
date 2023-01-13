package com.auth.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.auth.domain.entities.User;

public class UserTest {
  @Test
  public void shouldCreateUser() {
    String inputValidUsername = "validusername";
    String inputValidPassword = "12345678";
    User createdUser = User.create(inputValidUsername, inputValidPassword);
    assertEquals(createdUser.username.value, inputValidUsername);
  }

  @Test
  public void shouldThrowErrorIfUsernameIsInvalid() {
    String inputInvalidUsername = "invalid username";
    String inputValidPassword = "12345678";
    try {
      User.create(inputInvalidUsername, inputValidPassword);
    } catch(Error e) {
      assertEquals(e.getMessage(), "O nome de úsuario não cumpre os requisitos mínimos!");
    }
  }

  @Test
  public void shouldThrowErrorIfPasswordIsInvalid() {
    String inputValidUsername = "validusername";
    String inputInvalidPassword = "1234567";
    try {
      User.create(inputValidUsername, inputInvalidPassword);
    } catch(Error e) {
      assertEquals(e.getMessage(), "A senha não cumpre os requisitos mínimos!");
    }
  }
}
