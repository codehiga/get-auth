package com.auth.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.auth.domain.entities.Password;
import com.auth.domain.entities.errors.InvalidPasswordException;

public class PasswordTest {
  @Test
  public void shouldCreatePassword() {
    String inputPassword = "12345678";
    Password createdPassword = Password.create(inputPassword);
    assertEquals(inputPassword, createdPassword.password);
  }

  @Test
  public void shouldThrowInvalidPasswordException() {
    String invalidInputPassword = "1234567";
    try {
      Password.create(invalidInputPassword);
    } catch(InvalidPasswordException e) {
      assertEquals(e.getMessage(), "A senha não cumpre os requisitos mínimos!");
      assertEquals(e.name, "InvalidPasswordException");
    }
  }
}
