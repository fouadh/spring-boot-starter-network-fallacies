package com.fha.nf;

public class NetworkFailureException extends RuntimeException {
  public NetworkFailureException(String msg) {
    super(msg);
  }
}
