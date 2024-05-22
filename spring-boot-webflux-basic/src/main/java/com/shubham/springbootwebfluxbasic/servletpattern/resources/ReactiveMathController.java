package com.shubham.springbootwebfluxbasic.servletpattern.resources;

import com.shubham.springbootwebfluxbasic.exception.InputValidationFailedException;
import com.shubham.springbootwebfluxbasic.servletpattern.dto.Response;
import com.shubham.springbootwebfluxbasic.servletpattern.service.ReactiveMathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/maths")
public class ReactiveMathController {

    private final ReactiveMathService reactiveMathService;

    public ReactiveMathController(ReactiveMathService reactiveMathService) {
        this.reactiveMathService = reactiveMathService;
    }

    @GetMapping("/square/{number}")
    public Mono<Response<Integer>> findSquareReactive(@PathVariable int number) {
        if (number > 40)
            throw new InputValidationFailedException(number, "Number should be less than 40");
        return reactiveMathService.findSquareReactive(number);
    }

    @GetMapping("/v1/square/{number}")
    public Mono<Response<Integer>> findSquareReactiveV1(@PathVariable int number) {
        return reactiveMathService.findSquareReactiveV1(number);
    }

    @GetMapping("/v2/square/{number}")
    public Mono<ResponseEntity<Response<Integer>>> findSquareReactiveV2(@PathVariable int number) {
        return reactiveMathService.findSquareReactiveV2(number);
    }

    @GetMapping("/table/{number}")
    public Flux<String> findTableReactive(@PathVariable int number) throws InterruptedException {
        return reactiveMathService.findTableReactive(number);
    }
}
