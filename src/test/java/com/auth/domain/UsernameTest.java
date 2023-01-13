package com.auth.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.auth.domain.entities.Username;


public class UsernameTest {
  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void shouldCreateValidUsername() {
    String usernameInput = "valid_username";
    Username usernameCreated = Username.create(usernameInput);
    assertEquals(usernameInput, usernameCreated.username);
  }

  @Test
  public void shouldThrowErrorIfInvalidUsername() {
    String usernameInput = "invalid username";
    try {
      Username.create(usernameInput);
    } catch(Error e) {
      assertEquals(e.getMessage(), "Nome de úsuario inválido!");
    }
  }

  
}
