package com.example.demoWebflux.controller;

import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author bo.yang
 */
@RestController
@EnableRetry
public class RestTestController {

    @GetMapping("/hello")
    public Mono<String>  hello() {
        return Mono.just("hello");
    }
}
