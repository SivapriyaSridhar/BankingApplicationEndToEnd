package com.bankingManagementSystem.endToEnd.model;

public class ErrorResponseBody {
  private int status;
  private String message;

  public ErrorResponseBody() {}

  public ErrorResponseBody(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
