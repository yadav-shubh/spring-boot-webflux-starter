package com.shubham.springbootwebfluxbasic.reactivepattern.router;

import com.shubham.springbootwebfluxbasic.exception.InputValidationFailedException;
import com.shubham.springbootwebfluxbasic.exception.InputValidationFailedResponse;
import com.shubham.springbootwebfluxbasic.reactivepattern.handler.MathHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Configuration
public class MathRouter {

    private final MathHandler mathHandler;

    public MathRouter(MathHandler mathHandler) {
        this.mathHandler = mathHandler;
    }

    @Bean
    RouterFunction<ServerResponse> serverResponseRouterFunction() {
        return RouterFunctions.route().
                GET("/math/add/{first}/{second}", mathHandler::calculateAddition)
                .onError(InputValidationFailedException.class, exceptionHandler()).build();
    }

    private BiFunction<Throwable, ServerRequest, Mono<ServerResponse>> exceptionHandler() {
        return (throwable, serverRequest) -> {
            InputValidationFailedException inputValidationFailedException = (InputValidationFailedException) throwable;
            InputValidationFailedResponse inputValidationFailedResponse = new InputValidationFailedResponse();
            inputValidationFailedResponse.setMessage(inputValidationFailedException.getMessage());
            inputValidationFailedResponse.setResponseCode(400);
            inputValidationFailedResponse.setSuccess(false);
            return ServerResponse.badRequest().bodyValue(inputValidationFailedResponse);
        };
    }

}
