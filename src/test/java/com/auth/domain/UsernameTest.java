package com.auth.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.auth.domain.entities.Username;
import com.auth.domain.entities.errors.InvalidUsernameException;


public class UsernameTest {
  @Test
  public void shouldCreateValidUsername() {
    String usernameInput = "valid_username";
    Username createdUsername = Username.create(usernameInput);
    assertEquals(usernameInput, createdUsername.value);
  }

  @Test
  public void shouldThrowInvalidUsernameException() {
    String usernameInput = "invalid username";
    try {
      Username.create(usernameInput);
    } catch(InvalidUsernameException e) {
      assertEquals(e.getMessage(), "O nome de úsuario não cumpre os requisitos mínimos!");
      assertEquals(e.name, "InvalidUsernameException");
    }
  }
}
