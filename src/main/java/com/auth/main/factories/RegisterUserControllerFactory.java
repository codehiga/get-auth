package com.auth.main.factories;

import com.auth.application.usecases.RegisterUser;
import com.auth.controllers.RegisterUserController;

public class RegisterUserControllerFactory {
  public static RegisterUserController makeRegisterUserController() {
    RegisterUser usecase = new RegisterUser(RepositoryFactory.get());
    RegisterUserController controller = new RegisterUserController(usecase);
    return controller;
  }
}