package com.auth.interfaces.helpers;

import com.auth.interfaces.ports.HttpResponse;

public class Created {
  public static HttpResponse response() {
    return new HttpResponse(201, null);
  }
}