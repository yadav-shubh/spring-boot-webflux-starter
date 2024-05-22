package com.shubham.springbootwebfluxbasic.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputValidationFailedException extends RuntimeException {

    private int input;
    private String message;

    public InputValidationFailedException(int input, String message) {
        super(message);
        this.message = message;
        this.input = input;
    }

}
