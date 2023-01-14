package com.auth.controllers.helpers;

import com.auth.controllers.ports.HttpResponse;

public class Unauthorized {
  public static HttpResponse response(String message) {
    return new HttpResponse(400, message);
  }
}
