package com.auth.domain.ports;

import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.shared.Either;

public interface UserRepository {
  public Either<ValidationError, User> save(User user);
  public User findByUsername(String username);
  public boolean exists(String username);
}
