package com.example.demoWebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bo.yang
 */
@Service
public class RestTestService {

    @Autowired
    private RetryService retryService;

    public void handle() {
        retryService.send("12345");
    }


}
