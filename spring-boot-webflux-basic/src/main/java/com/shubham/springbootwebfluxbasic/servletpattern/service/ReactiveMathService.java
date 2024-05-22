package com.shubham.springbootwebfluxbasic.servletpattern.service;

import com.shubham.springbootwebfluxbasic.servletpattern.dto.Response;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveMathService {

    Mono<Response<Integer>> findSquareReactive(int number);

    Flux<String> findTableReactive(int number) throws InterruptedException;

    Mono<Response<Integer>> findSquareReactiveV1(int number);

    Mono<ResponseEntity<Response<Integer>>> findSquareReactiveV2(int number);
}
