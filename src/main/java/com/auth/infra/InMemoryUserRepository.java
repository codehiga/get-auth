package com.auth.infra;

import com.auth.domain.entities.User;
import com.auth.domain.errors.ValidationError;
import com.auth.domain.errors.ValidationError.ErrorType;
import com.auth.infra.errors.UsernameAlreadyExistsException;
import com.auth.infra.ports.UserRepository;
import com.auth.shared.Either;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

  private List<User> repository = new ArrayList<User>();

  public InMemoryUserRepository(List<User> repository) {
    this.repository = repository;
  }

  @Override
  public Either<ValidationError, User> save(User data) {
    if(exists(data.username.value)) {
      return Either.left(new ValidationError(ErrorType.USER_ALREADY_EXIST, new UsernameAlreadyExistsException().getMessage()));
    }
    this.repository.add(data);
    return Either.right(data);
  }

  @Override
  public User findByUsername(String username) {
    for(User user : this.repository) {
      if(user.username.value == username) {
        return user;
      }
    }
    return null;
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
