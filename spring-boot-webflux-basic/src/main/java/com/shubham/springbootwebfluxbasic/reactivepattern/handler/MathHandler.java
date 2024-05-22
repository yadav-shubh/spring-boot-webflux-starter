package com.shubham.springbootwebfluxbasic.reactivepattern.handler;

import com.shubham.springbootwebfluxbasic.reactivepattern.service.MathService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class MathHandler {

    private final MathService mathService;

    public MathHandler(MathService mathService) {
        this.mathService = mathService;
    }

    public Mono<ServerResponse> calculateAddition(ServerRequest serverRequest) {
        String first = serverRequest.pathVariable("first");
        String second = serverRequest.pathVariable("second");
        return mathService.calculateAddition(Integer.parseInt(first), Integer.parseInt(second));
    }
}
