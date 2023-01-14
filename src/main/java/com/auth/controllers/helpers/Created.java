package com.auth.controllers.helpers;

import com.auth.controllers.ports.HttpResponse;

public class Created {
  public static HttpResponse response() {
    return new HttpResponse(201, null);
  }
}