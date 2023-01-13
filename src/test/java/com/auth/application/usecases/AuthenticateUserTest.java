package com.auth.application.usecases;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.auth.application.dto.AuthResponseDTO;
import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.infra.repositories.InMemoryUserRepository;
import com.auth.shared.Either;

public class AuthenticateUserTest {
  @Test
  public void shouldReturnToken() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    AuthenticateUser authenticateUser = new AuthenticateUser(inMemoryUserRepository);
    Either<ValidationError, User> validUserToValidate = User.create("usernameGenToken", "12345678");
    inMemoryUserRepository.save(validUserToValidate.getRight());
    Either<ValidationError, AuthResponseDTO> authResponse = authenticateUser.execute(validUserToValidate.getRight(), "12345678");
    assertTrue(authResponse.isRight());
  }
  
}
