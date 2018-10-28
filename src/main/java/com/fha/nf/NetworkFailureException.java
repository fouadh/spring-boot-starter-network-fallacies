package com.fha.nf;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class NetworkFailureException extends RuntimeException {
    public NetworkFailureException(String msg) {
        super(msg);
    }
}
