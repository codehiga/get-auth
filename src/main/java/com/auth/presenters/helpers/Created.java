package com.auth.presenters.helpers;

import com.auth.presenters.ports.HttpResponse;

public class Created {
  public static HttpResponse response() {
    return new HttpResponse(201, null);
  }
}