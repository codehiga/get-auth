package com.auth.interfaces.helpers;

import com.auth.interfaces.ports.HttpResponse;

public class Unauthorized {
  public static HttpResponse response(String message) {
    return new HttpResponse(400, message);
  }
}
