package com.auth.controllers;

import com.auth.application.dto.AuthResponseDTO;
import com.auth.application.dto.AuthenticateUserDTO;
import com.auth.application.usecases.AuthenticateUser;
import com.auth.domain.errors.ValidationError;
import com.auth.shared.Either;

public class AuthenticateUserController {
  private AuthenticateUser usecase;

  public AuthenticateUserController(AuthenticateUser usecase) {
    this.usecase = usecase;
  }
  
  public AuthResponseDTO handle(AuthenticateUserDTO authUserData) {
    Either<ValidationError, AuthResponseDTO> response = this.usecase.execute(authUserData);
    if(response.isLeft()) {
      return null;
    }
    return response.getRight();
  }
}
