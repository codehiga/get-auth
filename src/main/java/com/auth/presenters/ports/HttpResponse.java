package com.auth.presenters.ports;

public class HttpResponse {
  public Integer statusCode;
  public String body;

  public HttpResponse(Integer statusCode, String body) {
    this.statusCode = statusCode;
    this.body = body;
  }
}
