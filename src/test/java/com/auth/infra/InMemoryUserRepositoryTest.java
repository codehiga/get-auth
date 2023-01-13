package com.auth.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.infra.errors.UsernameAlreadyExistsException;
import com.auth.infra.repositories.InMemoryUserRepository;
import com.auth.shared.Either;

public class InMemoryUserRepositoryTest {
  @Test
  public void shouldSaveUser() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    Either<ValidationError, User> user = User.create("usernametest", "passwordtest");
    inMemoryUserRepository.save(user.getRight());
    assertEquals(users.size(), 1);
    assertEquals(users.get(0), user.getRight());
  }

  @Test
  public void shouldNotSaveUserIfUsenameExists() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    Either<ValidationError, User> user = User.create("usernameduplicated", "passwordtest");
    inMemoryUserRepository.save(user.getRight());
    Either<ValidationError, User> error = inMemoryUserRepository.save(user.getRight());
    assertTrue(error.isLeft());
    assertEquals(error.getLeft().getMessage(), new UsernameAlreadyExistsException().getMessage());
  }

  @Test
  public void shouldReturnNullIfUserNotExist() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    String usernameNotExist = "notExist";
    User notFound = inMemoryUserRepository.findByUsername(usernameNotExist);
    assertEquals(notFound, null);
  }
}
