package com.auth.main.factories;

import java.util.ArrayList;
import java.util.List;

import com.auth.application.usecases.RegisterUser;
import com.auth.controllers.RegisterUserController;
import com.auth.domain.entities.User;
import com.auth.infra.InMemoryUserRepository;
import com.auth.infra.ports.UserRepository;

public class RegisterUserControllerFactory {

  public static RegisterUserController makeRegisterUserController() {
    List<User> users = new ArrayList<User>();
    UserRepository repository = new InMemoryUserRepository(users);
    RegisterUser usecase = new RegisterUser(repository);
    RegisterUserController controller = new RegisterUserController(usecase);
    return controller;
  }

}