package com.shubham.springbootwebfluxbasic.reactivepattern.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class MathService {

    public Mono<ServerResponse> calculateAddition(int a, int b) {
        return ServerResponse.ok().body(Mono.just(a + b), Integer.class);
    }
}
