package com.shubham.springbootwebfluxbasic.servletpattern.service.impl;

import com.shubham.springbootwebfluxbasic.servletpattern.dto.Response;
import com.shubham.springbootwebfluxbasic.exception.InputValidationFailedException;
import com.shubham.springbootwebfluxbasic.servletpattern.service.ReactiveMathService;
import com.shubham.springbootwebfluxbasic.servletpattern.utils.ResponsUtility;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static java.lang.Thread.sleep;

@Service
public class ReactiveMathServiceImpl implements ReactiveMathService {

    @Override
    public Mono<Response<Integer>> findSquareReactive(int number) {
        return Mono.just(ResponsUtility.getSuccessResponseReactive(number * number, "Square of " + number + " is " + number * number));
    }

    @Override
    public Flux<String> findTableReactive(int number) {
        return Flux.range(1, 10).publishOn(Schedulers.boundedElastic()).doOnNext(i -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).map(i -> String.format("%d * %d = %d", number, i, number * i));
    }

    @Override
    public Mono<Response<Integer>> findSquareReactiveV1(int number) {
        return Mono.just(number).handle((i, sink) -> {
            if (i > 40) {
                sink.error(new InputValidationFailedException(i, "Number should be less than 40"));
                return;
            }
            sink.next(number);
        }).cast(Integer.class).map(i -> ResponsUtility.getSuccessResponseReactive(i * i, "Square of " + i + " is " + i * i));
    }

    @Override
    public Mono<ResponseEntity<Response<Integer>>> findSquareReactiveV2(int number) {
        return Mono.just(number).filter(i -> i < 40).cast(Integer.class)
                .map(i -> ResponsUtility.getSuccessResponseReactive(i * i, "Square of " + i + " is " + i * i))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponsUtility.getErrorResponse(number, "Number should be less than 40"));
    }

}

