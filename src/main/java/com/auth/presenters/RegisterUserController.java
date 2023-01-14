package com.auth.presenters;

import com.auth.application.dto.CreateNewUserDTO;
import com.auth.application.usecases.RegisterUser;
import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.presenters.helpers.Created;
import com.auth.presenters.helpers.Unauthorized;
import com.auth.presenters.ports.HttpResponse;
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
