package com.auth.application.usecases;

import com.auth.application.dto.AuthResponseDTO;
import com.auth.application.dto.AuthenticateUserDTO;
import com.auth.domain.entities.Password;
import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.domain.errors.ValidationError.ErrorType;
import com.auth.infra.ports.UserRepository;
import com.auth.libs.JwtAdapter;
import com.auth.shared.Either;

public class AuthenticateUser {
  private final UserRepository userRepository;
  
  public AuthenticateUser(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public Either<ValidationError, AuthResponseDTO> execute(AuthenticateUserDTO authUserData) {
    Either<ValidationError, User> userOrError = User.create(authUserData.getUsername(), authUserData.getPassword());
    if(userOrError.isLeft()) {
      return Either.left(new ValidationError(ErrorType.LOGIN_FAILED, userOrError.getLeft().getMessage()));
    }
    User user = userOrError.getRight();
    User userOrNull = this.userRepository.findByUsername(user.username.value);
    if(userOrNull == null) {
      return Either.left(new ValidationError(ErrorType.USER_NOT_FOUND, "Usuário não encontrado"));
    }
    Boolean validPassword = Password.verifyPassword(authUserData.getPassword(), userOrNull.password.value);
    if(!validPassword) {
      return Either.left(new ValidationError(ErrorType.INVALID_PASSWORD, "Senha inválida."));
    }
    String token = JwtAdapter.generateToken(user.username.value);
    AuthResponseDTO authResponse = new AuthResponseDTO();
    authResponse.setToken(token);
    return Either.right(authResponse);
  }
}