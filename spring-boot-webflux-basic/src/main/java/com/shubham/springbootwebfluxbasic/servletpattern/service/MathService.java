package com.shubham.springbootwebfluxbasic.servletpattern.service;

import com.shubham.springbootwebfluxbasic.servletpattern.dto.Response;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MathService {
    ResponseEntity<Response<Integer>> findSquare(int number);

    ResponseEntity<Response<List<String>>> findTable(int number);
}
