package com.auth.presenters;

import com.auth.application.dto.CreateNewUserDTO;
import com.auth.application.usecases.RegisterUser;
import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.shared.Either;

public class RegisterUserController {
  private RegisterUser usecase;

  public RegisterUserController(RegisterUser usecase) {
    this.usecase = usecase;
  }
  
  public User handle(CreateNewUserDTO user) {
    Either<ValidationError, User> response = this.usecase.execute(user);
    if(response.isLeft()) {
      return null;
    }
    return response.getRight();
  }
}
