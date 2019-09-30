package com.example.demoWebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author bo.yang
 */
@Service
public class RetryService {

    @Autowired
    private RestTemplate restTemplate;

    @Retryable(value = {RuntimeException.class}, maxAttempts = 2, backoff = @Backoff(delay = 500L))
    public void send(String msg) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("msg:"+msg);
            responseEntity = restTemplate
                    .postForEntity("http://127.0.0.1:12312/test/recive2", msg, String.class);
        } catch (Exception e) {
            System.out.println("failed ,入库 ...............");
            throw new RuntimeException("分发消息失败");
        }
        if (null != responseEntity && responseEntity.getStatusCodeValue() >= 200 && responseEntity.getStatusCodeValue() < 300){
            System.out.println("ok ，入库.......");
        } else {
            System.out.println("failed ，入库 ...............");
            throw new RuntimeException("分发消息失败");
        }
    }
}

