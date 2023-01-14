package com.auth.infra.ports;

import com.auth.application.domain.entities.User;
import com.auth.application.domain.errors.ValidationError;
import com.auth.shared.Either;

public interface UserRepository {
  public Either<ValidationError, User> save(User user);
  public User findByUsername(String username);
  public boolean exists(String username);
}
