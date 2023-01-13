package com.auth.domain.ports;

import com.auth.domain.entities.User;

public interface UserRepository {
  public void save(User user);
  public User findByUsername(String username);
  public boolean exists(String username);
}
