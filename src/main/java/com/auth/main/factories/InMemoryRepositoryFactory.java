package com.auth.main.factories;

import java.util.ArrayList;
import java.util.List;

import com.auth.domain.entities.User;
import com.auth.infra.InMemoryUserRepository;
import com.auth.infra.ports.UserRepository;

public class InMemoryRepositoryFactory {
  public static UserRepository get() {
    List<User> users = new ArrayList<User>();
    UserRepository repository = new InMemoryUserRepository(users);
    return repository;
  }
}
