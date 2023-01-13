package com.auth.infra.repositories;

import java.util.ArrayList;
import java.util.List;

import com.auth.domain.entities.User;
import com.auth.domain.ports.UserRepository;
import com.auth.infra.errors.UsernameAlreadyExistsException;

public class InMemoryUserRepository implements UserRepository {

  private List<User> repository = new ArrayList<User>();

  public InMemoryUserRepository(List<User> repository) {
    this.repository = repository;
  }

  @Override
  public void save(User data) {
    if(exists(data.username.value)) {
      throw new UsernameAlreadyExistsException();
    }
    this.repository.add(data);
  }

  @Override
  public User findByUsername(String username) {
    User userFound = null;
    for(User user : this.repository) {
      if(user.username.value == username) {
        userFound = user;
      }
    }
    return userFound;
  }

  @Override
  public boolean exists(String username) {
    for(User user : this.repository) {
      if(user.username.value == username) {
        return true;
      }
    }
    return false;
  }
}
