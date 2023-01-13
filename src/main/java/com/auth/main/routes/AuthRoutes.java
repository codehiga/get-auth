package com.auth.main.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.application.dto.CreateNewUserDTO;
import com.auth.domain.entities.User;
import com.auth.main.factories.RegisterUserControllerFactory;
import com.auth.presenters.RegisterUserController;

@Controller
@RestController(value = "/api")
public class AuthRoutes {
  @PostMapping("/register-user")
  User registerUser(@RequestBody CreateNewUserDTO user) {
    RegisterUserController route = RegisterUserControllerFactory.makeRegisterUserController();
    return route.handle(user);
  }
}
