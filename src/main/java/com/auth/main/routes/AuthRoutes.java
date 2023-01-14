package com.auth.main.routes;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.application.dto.CreateNewUserDTO;
import com.auth.main.factories.RegisterUserControllerFactory;
import com.auth.presenters.RegisterUserController;
import com.auth.presenters.ports.HttpResponse;

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
}
