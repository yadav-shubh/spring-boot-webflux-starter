package com.shubham.springbootwebfluxbasic.servletpattern.utils;

import com.shubham.springbootwebfluxbasic.servletpattern.dto.Response;
import org.springframework.http.ResponseEntity;

public class ResponsUtility {

    public static <T> ResponseEntity<Response<T>> getSuccessResponse(T data, String message) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setMessage(message);
        response.setSuccess(true);
        response.setResponseCode(200);
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<Response<T>> getErrorResponse(T data, String message) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setMessage(message);
        response.setSuccess(false);
        response.setResponseCode(400);
        return ResponseEntity.ok(response);
    }

    public static <T> Response<T> getSuccessResponseReactive(T data, String message) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setMessage(message);
        response.setSuccess(true);
        response.setResponseCode(200);
        return response;
    }
}
