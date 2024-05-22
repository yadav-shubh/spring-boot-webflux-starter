package com.shubham.springbootwebfluxbasic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnAuthrorizeException extends RuntimeException {

    public UnAuthrorizeException(String message) {
        super(message);
    }
}
