package com.auth.interfaces.ports;

public class HttpResponse {
  public Integer statusCode;
  public String body;

  public HttpResponse(Integer statusCode, String body) {
    this.statusCode = statusCode;
    this.body = body;
  }
}
