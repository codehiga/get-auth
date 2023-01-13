package com.auth.infra;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.auth.domain.entities.User;
import com.auth.infra.errors.UsernameAlreadyExistsException;
import com.auth.infra.repositories.InMemoryUserRepository;

public class InMemoryUserRepositoryTest {
  @Test
  public void shouldSaveUser() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    User user = User.create("usernametest", "passwordtest");
    inMemoryUserRepository.save(user);
    assertEquals(users.size(), 1);
    assertEquals(users.get(0), user);
  }

  @Test
  public void shouldNotSaveUserIfUsenameExists() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    User user = User.create("usernameduplicated", "passwordtest");
    inMemoryUserRepository.save(user);

    try {
      inMemoryUserRepository.save(user);
    } catch(UsernameAlreadyExistsException error) {
      assertEquals(error.getMessage(), "Um usuário com esse username já existe!");
      assertEquals(error.name, "UsernameAlreadyExistsException");
    }
  }
}
