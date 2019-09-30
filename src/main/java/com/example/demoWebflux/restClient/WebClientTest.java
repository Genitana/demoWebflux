package com.example.demoWebflux.restClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.time.Duration;

/**
 * @author bo.yang
 */
public class WebClientTest {
private static Logger logger = LoggerFactory.getLogger(WebClientTest.class);
    public void sendTest() {
        org.springframework.web.reactive.function.client.WebClient webClient = org.springframework.web.reactive.function.client.WebClient.create();
        Mono<String> resp = webClient
                .post()
                .uri("http://127.0.0.1:12312/test/recive2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(new Object())
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(3));
        resp.subscribe(System.out::println);

        String result = resp.block();

        //
        Mono<ClientResponse> clientResponse = webClient
                .post()
                .uri("http://192.168.1.111:8080")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(new Object())
                .exchange()
                .timeout(Duration.ofSeconds(3))
//                .then(response -> response.bodyToMono(String.class))
                ;

    }

    public static void main(String[] args) throws IOException {

        WebClient webClient = WebClient.create();
        send(webClient);
        send(webClient);
        System.in.read();

    }

    public static void send(WebClient webClient) {
        logger.info("name:{}.......................", Thread.currentThread().getName());
        webClient
                .post()
                .uri("http://127.0.0.1:12312/test/recive")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("test")
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(3))
//                .publishOn(Schedulers.elastic())
                .retry(2)
                .doOnError(Exception.class, error -> {
                    logger.info("filed......................");
//                        consumeDOServiceImpl.saveOrUpdateByMessageIdGroupId(consumeDO);
                })
//                    .publishOn(Schedulers.elastic()).subscribe(System.out::println,System.out::println,()->System.out.print(1));
                .subscribe(t -> {
                    logger.info("success.....................");
                });
    }
}
