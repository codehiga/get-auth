package com.auth.domain.entities;

import com.auth.domain.entities.errors.InvalidPasswordException;
import com.auth.domain.entities.errors.InvalidUsernameException;
import com.auth.domain.errors.ValidationError;
import com.auth.domain.errors.ValidationError.ErrorType;
import com.auth.shared.Either;

public class User {
  public Username username;
  public Password password;

  private User(Username username, Password password) {
    this.username = username;
    this.password = password;
  }

  public static Either<ValidationError, User> create(String username, String password) throws InvalidUsernameException, InvalidPasswordException {
    Either<InvalidUsernameException, Username> usernameOrError = Username.create(username);
    Either<InvalidPasswordException, Password> passwordOrError = Password.create(password);
    if(usernameOrError.isLeft()) {
      return Either.left(new ValidationError(
        ErrorType.INVALID_USERNAME, 
        usernameOrError.getLeft().getMessage()
      ));
    }
    if(passwordOrError.isLeft()) {
      return Either.left(new ValidationError(
        ErrorType.INVALID_PASSWORD, 
        passwordOrError.getLeft().getMessage()
      ));
    }
    return Either.right(new User(usernameOrError.getRight(), passwordOrError.getRight()));
  }

}
