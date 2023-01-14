package com.auth.presenters.helpers;

import com.auth.presenters.ports.HttpResponse;

public class Unauthorized {
  public static HttpResponse response(String message) {
    return new HttpResponse(400, message);
  }
}
