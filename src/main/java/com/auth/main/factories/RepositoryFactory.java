package com.auth.main.factories;

import com.auth.domain.entities.User;
import com.auth.infra.InMemoryUserRepository;
import com.auth.infra.ports.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFactory {
  public static UserRepository get() {
    List<User> users = new ArrayList<User>();
    InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository(users);
    return inMemoryUserRepository;
  }
}
