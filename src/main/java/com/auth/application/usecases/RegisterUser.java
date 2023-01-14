package com.auth.application.usecases;

import com.auth.shared.dto.CreateNewUserDTO;
import com.auth.application.domain.entities.Password;
import com.auth.application.domain.entities.User;
import com.auth.application.domain.errors.ValidationError;
import com.auth.infra.errors.UsernameAlreadyExistsException;
import com.auth.infra.ports.UserRepository;
import com.auth.shared.Either;

public class RegisterUser {
  private UserRepository userRepository;
  
  public RegisterUser(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public Either<ValidationError, User> execute(CreateNewUserDTO createNewUser) {
    String hashedPassword = Password.hashPassword(createNewUser.getPassword());
    Either<ValidationError, User> user = User.create(createNewUser.getUsername(), hashedPassword);
    if(user.isLeft()) {
      return Either.left(user.getLeft());
    }
    Boolean userExists = this.userRepository.exists(createNewUser.getUsername());
    if(userExists) {
      return Either.left(new ValidationError(ValidationError.ErrorType.USER_ALREADY_EXIST, new UsernameAlreadyExistsException().getMessage()));
    }
    Either<ValidationError, User> response = this.userRepository.save(user.getRight());
    if(response.isLeft()) {
      return Either.left(response.getLeft());
    }
    return Either.right(user.getRight());
  }
}
