package com.auth.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.auth.application.dto.CreateNewUserDTO;
import com.auth.domain.entities.User;
import com.auth.domain.entities.errors.InvalidUsernameException;
import com.auth.domain.errors.ValidationError;
import com.auth.infra.repositories.InMemoryUserRepository;
import com.auth.shared.Either;

public class RegisterUserTest {
  @Test
  public void shouldCreateUser() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository repository = new InMemoryUserRepository(users);
    RegisterUser usecase = new RegisterUser(repository);
    CreateNewUserDTO createNewUserDTO = new CreateNewUserDTO();
    createNewUserDTO.setUsername("testUseCaseExecute");
    createNewUserDTO.setPassword("12345678");
    usecase.execute(createNewUserDTO);
    assertEquals(users.size(), 1);
    assertEquals(users.get(0).username.value, "testUseCaseExecute");
  }

  @Test
  public void shouldNotCreateUserIfUsernameIsInvalid() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository repository = new InMemoryUserRepository(users);
    RegisterUser usecase = new RegisterUser(repository);
    CreateNewUserDTO createNewUserDTO = new CreateNewUserDTO();
    createNewUserDTO.setUsername("test_invalid_username");
    createNewUserDTO.setPassword("12345678");
    Either<ValidationError, User> usecaseResponse = usecase.execute(createNewUserDTO);
    assertTrue(usecaseResponse.isLeft());
    assertEquals(usecaseResponse.getLeft().getMessage(), new InvalidUsernameException().getMessage());
  }
}
