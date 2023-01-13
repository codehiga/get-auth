package com.auth.domain.entities.errors;

public class InvalidUsernameException extends Error {
  public String name = "InvalidUsernameException";

  public InvalidUsernameException() {
    super("Nome de úsuario inválido!");
  }
}
