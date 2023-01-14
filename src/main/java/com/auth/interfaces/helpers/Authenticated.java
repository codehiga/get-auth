package com.auth.interfaces.helpers;

import com.auth.shared.dto.AuthResponseDTO;
import com.auth.interfaces.ports.HttpResponse;

public class Authenticated {
  public static HttpResponse response(AuthResponseDTO message) {
    return new HttpResponse(200, message.getToken());
  }
}
