package com.auth.main.routes;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.application.dto.AuthenticateUserDTO;
import com.auth.application.dto.CreateNewUserDTO;
import com.auth.controllers.AuthenticateUserController;
import com.auth.controllers.RegisterUserController;
import com.auth.controllers.ports.HttpResponse;
import com.auth.main.factories.AuthenticateUserControllerFactory;
import com.auth.main.factories.RegisterUserControllerFactory;

@Controller
@RestController
public class AuthRoutes {
  @PostMapping("/register-user")
  ResponseEntity<HttpResponse> registerUser(@RequestBody CreateNewUserDTO user) {
    RegisterUserController route = RegisterUserControllerFactory.makeRegisterUserController();
    HttpResponse response = route.handle(user);
    HttpStatusCode statusCodeResponse = HttpStatusCode.valueOf(response.statusCode);
    return new ResponseEntity<HttpResponse>(response, statusCodeResponse);
  }

  @PostMapping("/login")
  ResponseEntity<HttpResponse> authenticateUser(@RequestBody AuthenticateUserDTO user) {
    AuthenticateUserController route = AuthenticateUserControllerFactory.makeAuthenticateUserController();
    HttpResponse response = route.handle(user);
    HttpStatusCode statusCodeResponse = HttpStatusCode.valueOf(response.statusCode);
    return new ResponseEntity<HttpResponse>(response, statusCodeResponse);
  }
}
