package com.shubham.springbootwebfluxbasic.servletpattern.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Response<T> {

    private int responseCode;
    private boolean error;
    private boolean success;
    private T data;
    private String message;

}
