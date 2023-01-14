package com.auth.interfaces;

import com.auth.shared.dto.CreateNewUserDTO;
import com.auth.application.usecases.RegisterUser;
import com.auth.interfaces.helpers.Created;
import com.auth.interfaces.helpers.Unauthorized;
import com.auth.interfaces.ports.HttpResponse;
import com.auth.application.domain.entities.User;
import com.auth.application.domain.errors.ValidationError;
import com.auth.shared.Either;

public class RegisterUserController {
  private RegisterUser usecase;

  public RegisterUserController(RegisterUser usecase) {
    this.usecase = usecase;
  }
  
  public HttpResponse handle(CreateNewUserDTO user) {
    Either<ValidationError, User> response = this.usecase.execute(user);
    if(response.isLeft()) {
      return Unauthorized.response(response.getLeft().getMessage());
    }
    return Created.response();
  }
}
