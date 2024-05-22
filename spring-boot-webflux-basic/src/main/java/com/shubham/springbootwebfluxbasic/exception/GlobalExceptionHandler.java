package com.shubham.springbootwebfluxbasic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InputValidationFailedException.class)
    public ResponseEntity<InputValidationFailedResponse> handleInputValidationFailedException(InputValidationFailedException ex) {
        InputValidationFailedResponse response = new InputValidationFailedResponse();
        response.setMessage(ex.getMessage());
        response.setResponseCode(400);
        response.setSuccess(false);
        return ResponseEntity.status(400).body(response);
    }

    @ExceptionHandler(UnAuthrorizeException.class)
    public ResponseEntity<ProblemDetail> handleUnAuthrorizeException(UnAuthrorizeException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return ResponseEntity.status(401).body(problemDetail);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ProblemDetail> handleBadRequestException(BadRequestException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(400).body(problemDetail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleBadRequestException(Exception ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.OK, ex.getMessage());
        return ResponseEntity.status(200).body(problemDetail);
    }
}
