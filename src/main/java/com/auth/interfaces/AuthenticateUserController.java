package com.auth.interfaces;

import com.auth.shared.dto.AuthResponseDTO;
import com.auth.shared.dto.AuthenticateUserDTO;
import com.auth.application.usecases.AuthenticateUser;
import com.auth.interfaces.helpers.Authenticated;
import com.auth.interfaces.helpers.Unauthorized;
import com.auth.interfaces.ports.HttpResponse;
import com.auth.application.domain.errors.ValidationError;
import com.auth.shared.Either;

public class AuthenticateUserController {
  private AuthenticateUser usecase;

  public AuthenticateUserController(AuthenticateUser usecase) {
    this.usecase = usecase;
  }
  
  public HttpResponse handle(AuthenticateUserDTO authUserData) {
    Either<ValidationError, AuthResponseDTO> response = this.usecase.execute(authUserData);
    if(response.isLeft()) {
      return Unauthorized.response(response.getLeft().getMessage());
    }
    return Authenticated.response(response.getRight());
  }
}
