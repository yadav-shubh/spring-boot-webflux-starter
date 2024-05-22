package com.shubham.springbootwebfluxbasic.webclient;

import com.shubham.springbootwebfluxbasic.dto.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@SpringBootTest
public class WebClientTest {

    private final WebClient webClient;

    public WebClientTest() {
        this.webClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    @Test
    public void monoVerifierTest() {
        Mono<String> stringMono = webClient.get().uri("/posts").retrieve().bodyToMono(String.class);

        StepVerifier.create(stringMono).expectNextMatches(s -> s.contains("title")).verifyComplete();
    }

    @Test
    public void fluxVerifierTest() {
        Flux<Post> stringMono = webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class)
                .doOnNext(System.out::println);
        StepVerifier.create(stringMono).expectNextCount(100).verifyComplete();
    }
}
