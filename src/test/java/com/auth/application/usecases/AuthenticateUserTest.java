package com.auth.application.usecases;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.auth.application.dto.AuthResponseDTO;
import com.auth.application.dto.AuthenticateUserDTO;
import com.auth.application.domain.entities.User;
import com.auth.application.domain.errors.ValidationError;
import com.auth.infra.repositories.InMemoryUserRepository;
import com.auth.shared.Either;

public class AuthenticateUserTest {
  @Test
  public void shouldReturnToken() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    AuthenticateUser authenticateUser = new AuthenticateUser(inMemoryUserRepository);
    AuthenticateUserDTO authUserData = new AuthenticateUserDTO();
    authUserData.setUsername("validUserToValidate");
    authUserData.setPassword("12345678");
    Either<ValidationError, User> validUserToValidate = User.create(authUserData.getUsername(), authUserData.getPassword());
    inMemoryUserRepository.save(validUserToValidate.getRight());
    Either<ValidationError, AuthResponseDTO> authResponse = authenticateUser.execute(authUserData);
    assertTrue(authResponse.isRight());
  }
  
}
