package com.auth.application.usecases;

import com.auth.application.dto.CreateNewUserDTO;
import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.domain.ports.UserRepository;
import com.auth.shared.Either;

public class RegisterUser {
  private UserRepository userRepository;
  
  public RegisterUser(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public Either<ValidationError, User> execute(CreateNewUserDTO createNewUser) {
    Either<ValidationError, User> user = User.create(createNewUser.getUsername(), createNewUser.getPassword());
    if(user.isLeft()) {
      return Either.left(user.getLeft());
    }
    Either<ValidationError, User> response = this.userRepository.save(user.getRight());
    if(response.isLeft()) {
      return Either.left(response.getLeft());
    }
    return Either.right(user.getRight());
  }
}
