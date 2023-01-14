package com.auth.main.factories;

import com.auth.application.usecases.AuthenticateUser;
import com.auth.controllers.AuthenticateUserController;

public class AuthenticateUserControllerFactory {
  public static AuthenticateUserController makeAuthenticateUserController() {
    AuthenticateUser usecase = new AuthenticateUser(InMemoryRepositoryFactory.get());
    AuthenticateUserController controller = new AuthenticateUserController(usecase);
    return controller;
  }
}
