package com.shubham.springbootwebfluxbasic.exception;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InputValidationFailedResponse {

    private String message;
    private int responseCode;
    private boolean success;
}
