package com.example.demoWebflux.restClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.scheduler.Schedulers;
import reactor.retry.Retry;

import java.time.Duration;

/**
 * @author bo.yang
 */
public class RetryWebClient {
    private static final Logger logger = LoggerFactory.getLogger(RetryWebClient.class);
    public static void main(String[] args) throws Exception {
        logger.info("*************test");
        WebClient.create()
                .post()
                .uri("http://127.0.0.1:12312/test/recive2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("123")
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(3))
                .publishOn(Schedulers.elastic())
                .doOnError(Exception.class, err -> {
                    logger.error("**************ERROR msg:{}", err.getMessage());
                })
//                .retry(3)
                .retryWhen(Retry.any()
                        .retryMax(2)
                        .fixedBackoff(Duration.ofMillis(500))
//                        .exponentialBackoff(Duration.ofSeconds(3), Duration.ofSeconds(10))
//                        .doOnRetry(t -> logger.info("retry***************"+111))
                )
//                .publishOn(Schedulers.elastic()).subscribe(t -> logger.warn(t),System.out::println,()->System.out.print(1));
                .subscribe(t -> System.out.println("success  " +Thread.currentThread().getName() + ",backoff 返回结果 " + t + "*****************"))
        ;
        System.out.println("********************是异步**********************************************************");

        System.in.read();
    }
}
